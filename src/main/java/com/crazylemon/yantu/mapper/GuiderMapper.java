package com.crazylemon.yantu.mapper;

import com.crazylemon.yantu.entity.Guider;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crazylemon.yantu.utils.PageModel;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangzh
 * @since 2018-10-09
 */
@Repository
public interface GuiderMapper extends BaseMapper<Guider> {
    /**
     *  分页查询导游
     * @param pageModel
     * @return
     */
    @Select("select * from guider limit #{startRecord} , #{pageSize}")
    public List<Guider> getGuiderBypage(PageModel<Guider> pageModel);

    /**
     * 获取导游总数
     * @return
     */
    @Select("select count(guider_id) from guider")
    public Integer getCount();
}
