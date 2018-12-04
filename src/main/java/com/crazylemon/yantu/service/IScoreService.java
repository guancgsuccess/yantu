package com.crazylemon.yantu.service;

import com.crazylemon.yantu.entity.Score;
import com.baomidou.mybatisplus.extension.service.IService;
import com.crazylemon.yantu.utils.ServerResponse;
import com.crazylemon.yantu.vo.ScoreVO;
import com.crazylemon.yantu.vo.ServiceResult;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangzh
 * @since 2018-10-09
 */
public interface IScoreService extends IService<Score> {
    ServerResponse<Score> saveScoreGrade(Score score);

    ServiceResult<List<ScoreVO>> getScenicScores(Integer scenicId);
}
