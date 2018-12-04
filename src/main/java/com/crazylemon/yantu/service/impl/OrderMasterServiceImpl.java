package com.crazylemon.yantu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crazylemon.yantu.entity.*;
import com.crazylemon.yantu.enums.OrderStatusEnums;
import com.crazylemon.yantu.mapper.OrderMasterMapper;
import com.crazylemon.yantu.service.IOrderMasterService;
import com.crazylemon.yantu.utils.OrderInfoUtil;
import com.crazylemon.yantu.vo.OrderVO;
import com.crazylemon.yantu.vo.ScenicVO;
import com.crazylemon.yantu.vo.ServiceResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wangzh
 * @since 2018-10-17
 */
@Service
public class OrderMasterServiceImpl extends ServiceImpl<OrderMasterMapper, OrderMaster> implements IOrderMasterService {

    @Resource
    private OrderMasterMapper orderMasterMapper;

    @Autowired
    private TouristServiceImpl touristService;

    @Autowired
    private OrderScenicServiceImpl orderScenicService;

    @Autowired
    private PlanorderServiceImpl planorderService;

    @Autowired
    private ScenicServiceImpl scenicService;

    @Autowired
    private PlanServiceImpl planService;


    /**
     * 保存订单主表
     *
     * @param orderInfoUtil 订单主表视图对象
     * @return
     */
    @Override
    @Transactional
    public ServiceResult<Integer> saveOrderMaster(OrderInfoUtil orderInfoUtil) {
        //有效性判断
        if (orderInfoUtil == null) {
            return ServiceResult.createByError("订单为空,添加失败");
        }
        //订单主表
        OrderMaster orderMaster = new OrderMaster();
        //创建时间
        orderMaster.setOrderCreatetime(LocalDateTime.now());
        // 状态
        orderMaster.setOrderStatus(0);
        // 用户ID
        orderMaster.setVisitorId(orderInfoUtil.getVisitorId());
        //保险信息
        orderMaster.setOrderInsurance(orderInfoUtil.getOrderInsurance());
        //订单天数 通过景点和Plan的时间计算-价格计算
        Double sumPrice = 0.0;
        Integer scenicId = orderInfoUtil.getScenicId();
        Integer planId = orderInfoUtil.getPlanId();
        Scenic scenic = null;
        Plan plan = null;
        if (scenicId != null){
            scenic = (Scenic) scenicService.getById(scenicId).getData();
            orderMaster.setOrderDays(Integer.parseInt(scenic.getScenicXx()));
            sumPrice = orderInfoUtil.getOrderNum()*scenic.getScenicPrice();
        }
        if (planId != null) {
            plan = planService.getById(planId);
            orderMaster.setOrderDays(Integer.parseInt(plan.getPlanXx()));
            sumPrice = plan.getPlanPrice()*orderInfoUtil.getOrderNum();
        }
        //订单出游人数
        orderMaster.setOrderNum(orderInfoUtil.getOrderNum());
        orderMaster.setOrderPrice(sumPrice);

        //保存订单主表
        System.out.println(orderMaster);
        Integer result = orderMasterMapper.saveOrder(orderMaster);

        //添加出游人信息
        for (Tourist tourist : orderInfoUtil.getTouristList()) {
            tourist.setOrderId(orderMaster.getOrderId());
            tourist.setTouristStatus(1);
            touristService.save(tourist);
        }

        //添加order_scenic关联表信息

        if (scenic!=null){
            OrderScenic orderScenic = new OrderScenic();
            orderScenic.setOrderId(orderMaster.getOrderId());
            orderScenic.setScenicId(scenic.getScenicId());
            orderScenicService.saveOrderScenic(orderScenic);
        }

        //添加order_plan关联表信息
        if (plan!=null){
            Planorder planorder = new Planorder();
            planorder.setOrderId(orderMaster.getOrderId());
            planorder.setPlanId(plan.getPlanId());
            planorder.setOrderPlanStatus(1);
            planorderService.save(planorder);
        }
        return ServiceResult.createByCheckSuccess("添加成功", orderMaster.getOrderId());
    }

    @Override
    public ServiceResult<OrderVO> getOrderById(Integer orderId) {

        OrderMaster orderMaster = orderMasterMapper.getById(orderId);
        if (orderMaster == null) {
            return ServiceResult.createByError("查询失败");
        }

        OrderVO orderVO = new OrderVO();
        //属性拷贝
        BeanUtils.copyProperties(orderMaster, orderVO);

        //封装订单集合
        //出游人集合
        orderVO.setTouristList(touristService.list(new QueryWrapper<Tourist>().eq("order_id", orderId)));
        //景点集合
        List<Integer> scenicIdList = orderScenicService.getScenicIdList(orderId);
        List<ScenicVO> scenicList = new ArrayList<>();
        for (Integer scenicId : scenicIdList) {
            ScenicVO scenicVO = scenicService.getScenicById(scenicId).getData();
            scenicVO.setScenicNum(orderScenicService.getOne(new QueryWrapper<OrderScenic>().eq("scenic_id",scenicId)).getOrderScenicNum());
            scenicList.add(scenicVO);
        }

        //计划集合
        List<Integer> planIdList = planorderService.getPlanIdList(orderId);
        List<Plan> planList = new ArrayList<>();
        for (Integer planId : planIdList) {
            planList.add(planService.getById(planId));
        }
        orderVO.setScenicList(scenicList);
        orderVO.setPlanList(planList);

        return ServiceResult.createByCheckSuccess("查询成功", orderVO);
    }

    @Override
    public ServiceResult<Integer> updateOrderStatusToSuccess(Integer orderId) {
        //若订单已取消则不设置状态为已完成
        Integer orderStatus = orderMasterMapper.selectById(orderId).getOrderStatus();
        if (orderStatus.equals(OrderStatusEnums.CANCEL.getCode())) {
            return ServiceResult.createByError("订单已经是取消状态了");
        }
        Integer result = orderMasterMapper.updateOrderStatus(OrderStatusEnums.FINISH.getCode(), orderId);
        return ServiceResult.createByCheckSuccess("已更改订单状态为成功",result);
    }

    @Override
    @Transactional
    public ServiceResult<Integer> updateOrderStatusToCancel(Integer orderId) {
        //若订单已完成,则不可取消
        Integer orderStatus = orderMasterMapper.selectById(orderId).getOrderStatus();
        if (orderStatus.equals(OrderStatusEnums.FINISH.getCode())) {
            return ServiceResult.createByError("订单已完成,不可取消");
        }

        //修改订单主表状态为已取消
        Integer result = orderMasterMapper.updateOrderStatus(OrderStatusEnums.CANCEL.getCode(), orderId);
        //修改关联表状态为已取消
        orderScenicService.setStatusLoseById(orderId);
        planorderService.setStatusLoseById(orderId);
        //修改出游人状态为0
        touristService.setTouristStatusToCancel(orderId);
        return ServiceResult.createByCheckSuccess("订单状态修改为已取消",result);
    }

    @Override
    public ServiceResult<List<OrderVO>> getOrderByVisitorId(Integer visitorId) {
        if (null == visitorId) {
            return ServiceResult.createByError("用户不存在");
        }

        //订单集合
        List<OrderMaster> orderMasterList = orderMasterMapper.getByVisitorId(visitorId);
        //封装完整的订单集合
        List<OrderVO> orderVOList = new ArrayList<>();
        for (OrderMaster orderMaster : orderMasterList) {
            OrderVO orderVO = this.getOrderById(orderMaster.getOrderId()).getData();
            orderVOList.add(orderVO);
        }
        //返回用户订单数据
        return ServiceResult.createByCheckSuccess("查询用户订单成功",orderVOList);
    }

    @Override
    public ServiceResult<IPage<OrderMaster>> listOrderByPage(Integer currentPage,Integer visitorId) {
        //总页数
        Integer totalSize = orderMasterMapper.selectCount(new QueryWrapper<OrderMaster>()
                .eq("visitor_id",visitorId));

        //默认显示五条数据;
        Integer pageSize = 6;

        Integer sumPage = (totalSize/pageSize==0?totalSize/pageSize:totalSize/pageSize+1);
        List<OrderVO> orderVOList = new ArrayList<>();
        IPage<OrderMaster> orderMasterIPage;
        //防止分页溢出
        if (currentPage <= sumPage){
            orderMasterIPage = orderMasterMapper.selectPage(
                    new Page<>(currentPage,pageSize),
                    new QueryWrapper<OrderMaster>().
                            eq("visitor_id",visitorId).orderByDesc("order_createtime")
            );
            for (OrderMaster order:orderMasterIPage.getRecords()){
                ServiceResult<OrderVO> orderVOServiceResult = this.getOrderById(order.getOrderId());
                orderVOList.add(orderVOServiceResult.getData());
            }
        }else{
            orderMasterIPage = orderMasterMapper.selectPage(
                    new Page<>(sumPage,pageSize),
                    new QueryWrapper<OrderMaster>().
                            eq("visitor_id",visitorId).orderByDesc("order_createtime")
            );
            for (OrderMaster order:orderMasterIPage.getRecords()){
                ServiceResult<OrderVO> orderVOServiceResult = this.getOrderById(order.getOrderId());
                orderVOList.add(orderVOServiceResult.getData());
            }
        }
        System.out.println(orderVOList);
        System.out.println(orderVOList.size());

        orderMasterIPage.setTotal(totalSize);
        orderMasterIPage.setPages(sumPage);
        return ServiceResult.createByCheckSuccess("分页查询成功",orderMasterIPage);
    }
}
