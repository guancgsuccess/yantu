package com.crazylemon.yantu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crazylemon.yantu.entity.OrderMaster;
import com.crazylemon.yantu.entity.OrderScenic;
import com.crazylemon.yantu.entity.Score;
import com.crazylemon.yantu.entity.Visitor;
import com.crazylemon.yantu.mapper.OrderMasterMapper;
import com.crazylemon.yantu.mapper.ScoreMapper;
import com.crazylemon.yantu.service.IOrderMasterService;
import com.crazylemon.yantu.service.IOrderScenicService;
import com.crazylemon.yantu.service.IScoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crazylemon.yantu.service.IVisitorService;
import com.crazylemon.yantu.utils.ResponseCode;
import com.crazylemon.yantu.utils.ServerResponse;
import com.crazylemon.yantu.vo.ScoreVO;
import com.crazylemon.yantu.vo.ServiceResult;
import org.apache.ibatis.annotations.AutomapConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangzh
 * @since 2018-10-09
 */
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements IScoreService {
    private final ScoreMapper scoreMapper;
    private final OrderMasterMapper orderMasterMapper;

    @Autowired
    private IOrderScenicService orderScenicService;

    @Autowired
    private IScoreService scoreService;

    @Autowired
    private IVisitorService visitorService;

    @Autowired
    public ScoreServiceImpl(ScoreMapper scoreMapper, OrderMasterMapper orderMasterMapper) {
        this.scoreMapper = scoreMapper;
        this.orderMasterMapper = orderMasterMapper;
    }

    @Override
    public ServerResponse<Score> saveScoreGrade(Score score) {
        if (score.getOrderId() == null || score.getOrderId() == 0) {
            System.out.println("scoreId 不能为空或0");
            return new ServerResponse(ResponseCode.ERROR.getCode(), "失败");
        } else if (score.getScoreGrade() == null || score.getScoreGrade() == 0) {
            return new ServerResponse<Score>(ResponseCode.ERROR.getCode(), "service层 scoregrade不能为空或0");
        } else {
            Integer i = scoreMapper.saveScore(score);
            Integer j = orderMasterMapper.updateOrderStatus(3,score.getOrderId());
            if (i > 0 && j > 0) {
                return new ServerResponse<Score>(ResponseCode.SUCCESS.getCode(), score, "success");
            } else {
                return new ServerResponse<Score>(ResponseCode.ERROR.getCode(), "添加失败");
            }

        }

    }

    @Override
    public ServiceResult<List<ScoreVO>> getScenicScores(Integer scenicId) {

        //根据景点Id,查询订单集合...
        List<OrderScenic> orderIdList = orderScenicService.list(new QueryWrapper<OrderScenic>()
                                            .eq("scenic_id",scenicId).orderByDesc("order_id")
        );
        System.out.println(orderIdList);
        if (orderIdList.size()==0){
            return ServiceResult.createByError("景点不存在");
        }
        List<ScoreVO> scoreVOS = new ArrayList<>();

        //根据订单ID查询评分信息 and 根据订单ID,查询Visitor信息
        for (OrderScenic orderScenic:orderIdList) {
            Integer orderId =  orderScenic.getOrderId();

            OrderMaster orderMaster = orderMasterMapper.getById(orderId);
            Integer visitorId =  orderMaster.getVisitorId();
            Score score = scoreService.getOne(new QueryWrapper<Score>().eq("order_id",orderId));
            if (null != score){
                ScoreVO scoreVO = visitorService.getScoreVO(visitorId);

                BeanUtils.copyProperties(score,scoreVO);
                scoreVO.setOrderCreatetime(orderMaster.getOrderCreatetime());
                scoreVOS.add(scoreVO);
            }
        }

        if (null == scoreVOS){
            return ServiceResult.createByError("查询信息为空");
        }

        //封装数据,返回给Controller
        return ServiceResult.createByCheckSuccess("查询成功",scoreVOS);
    }
}
