package com.crazylemon.yantu.mapper;

import com.crazylemon.yantu.entity.Score;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangzh
 * @since 2018-10-09
 */
@Repository
public interface ScoreMapper extends BaseMapper<Score> {
    @Insert("insert into score (order_id,score_grade,score_status,score_xx) values(#{orderId},#{scoreGrade},#{scoreStatus},#{scoreXx})")
    int saveScore(Score score);
}
