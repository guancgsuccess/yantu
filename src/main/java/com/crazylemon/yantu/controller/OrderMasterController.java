package com.crazylemon.yantu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crazylemon.yantu.service.impl.OrderMasterServiceImpl;
import com.crazylemon.yantu.utils.OrderInfoUtil;
import com.crazylemon.yantu.vo.OrderVO;
import com.crazylemon.yantu.vo.ServiceResult;
import com.crazylemon.yantu.entity.OrderMaster;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangzh
 * @since 2018-10-17
 */
@RestController
@RequestMapping("/order")
public class OrderMasterController {

    @Autowired
    private OrderMasterServiceImpl orderMasterService;

    /**
     * 用户查看订单详情
     * @param orderId
     * @return
     */
    @GetMapping("/{id}")
    public ServiceResult<OrderVO> getOrderVOById(@PathVariable("id") Integer orderId){

        ServiceResult<OrderVO> orderVOServiceResult = orderMasterService.getOrderById(orderId);
        return orderVOServiceResult;
    }

    /**
     * 用户分页查看自己的所有订单----pageSize=5
     * @param pageCode
     * @param visitorId
     * @return
     */
    @GetMapping("/page/{visitorId}/{pageCode}")
    public ServiceResult<IPage<OrderMaster>> getOrderBtPage(@PathVariable("visitorId") Integer visitorId,@PathVariable("pageCode") Integer pageCode) {
        //测试数据---实际数据从Session中获取
        if (null == pageCode && pageCode <= 0) {
            pageCode = 1 ;
        }
        ServiceResult<IPage<OrderMaster>> pageServiceResult = orderMasterService.listOrderByPage(pageCode,visitorId);
        return pageServiceResult;
    }

    /**
     * 设置订单状态为已完成,等待订单支付后显示订单状态已完成
     * @param id
     * @return
     */
    @PutMapping("/ok")
    public ServiceResult<Integer> successOrder(@RequestParam("orderId") Integer id){
        System.out.println("id = "+ id);
        return orderMasterService.updateOrderStatusToSuccess(id);

    }

    /**
     * 用户自己可以取消未完成的订单.
     * @param id
     * @return ServiceResult<Integer>
     */
    @PutMapping("/cancel")
    public ServiceResult<Integer> cancelOrder(@RequestParam("orderId") Integer id){
        return orderMasterService.updateOrderStatusToCancel(id);
    }

    @PostMapping("/save")
    public ServiceResult<Integer> saveMyOrder(@RequestBody String orderInfoUtilJson) throws IOException {

        System.out.println(orderInfoUtilJson);
        ObjectMapper mapper = new ObjectMapper();
        OrderInfoUtil orderInfoUtil = mapper.readValue(orderInfoUtilJson,OrderInfoUtil.class);
        System.out.println(orderInfoUtil);
        ServiceResult<Integer> result = orderMasterService.saveOrderMaster(orderInfoUtil);
        return result;
    }


}
