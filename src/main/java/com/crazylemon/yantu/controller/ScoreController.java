package com.crazylemon.yantu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crazylemon.yantu.entity.Score;
import com.crazylemon.yantu.service.IScoreService;
import com.crazylemon.yantu.utils.ServerResponse;
import com.crazylemon.yantu.vo.ScoreVO;
import com.crazylemon.yantu.vo.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangzh
 * @since 2018-10-09
 */
@RestController
@RequestMapping("/yantu/score")
public class ScoreController {

    private final IScoreService iScoreService;

    @Autowired
    public ScoreController(IScoreService iScoreService) {
        this.iScoreService = iScoreService;
    }

    @PostMapping("/scoreGrade")
    public ServerResponse<Score> saveScoreGrade(Score score) {
        return iScoreService.saveScoreGrade(score);
    }

    @GetMapping("/{orderId}")
    public ServiceResult<Score> getScoreById(@PathVariable("orderId") Integer orderId){
        Score score = iScoreService.getOne(new QueryWrapper<Score>().eq("order_id",orderId));
        if (score!=null){
            return ServiceResult.createByCheckSuccess("查询成功",score);
        }else{
            return ServiceResult.createByError("查询失败");
        }

    }

    @GetMapping("/scenic/{scenicId}")
    public ServiceResult<List<ScoreVO>> getScenicScore(@PathVariable("scenicId") Integer scenicId){
        if (null != scenicId){
            return iScoreService.getScenicScores(scenicId);
        }else{
            return ServiceResult.createByError("查询评分失败");
        }

    }
}
