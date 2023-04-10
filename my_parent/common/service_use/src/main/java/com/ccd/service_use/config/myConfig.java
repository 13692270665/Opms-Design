package com.ccd.service_use.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author :ccd
 * @date : 2023/4/10 17:23
 */
@Configuration
public class myConfig {
        //逻辑删除插件
        @Bean
        public ISqlInjector sqlInjector() {
            return new LogicSqlInjector();
        }

        //分页插件
        @Bean
        public PaginationInterceptor paginationInterceptor() {
            return new PaginationInterceptor();
        }
}
