package com.crazylemon.yantu.service.impl;

import com.crazylemon.yantu.entity.Category;
import com.crazylemon.yantu.mapper.CategoryMapper;
import com.crazylemon.yantu.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangzh
 * @since 2018-10-09
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
