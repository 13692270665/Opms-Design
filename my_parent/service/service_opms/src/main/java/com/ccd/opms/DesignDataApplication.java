package com.ccd.opms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author :ccd
 * @date : 2023/2/23 20:11 
 */
@SpringBootApplication
@MapperScan("com.ccd.opms.mapper")
@ComponentScan(basePackages = {"com.ccd"})
public class DesignDataApplication {
    public static void main(String[] args) {
        SpringApplication.run(DesignDataApplication.class, args);
    }
}
