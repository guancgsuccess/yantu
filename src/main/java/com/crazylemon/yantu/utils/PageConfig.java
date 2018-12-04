package com.crazylemon.yantu.utils;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: Wangzh
 * Date: 2018-10-19
 * Time: 15:17
 * Desc: 描述
 */

@Configuration
@MapperScan("com.crazylemon.yantu.mapper")
public class PageConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
