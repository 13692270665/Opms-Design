package com.ccd.kbms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author :ccd
 * @date : 2023/2/23 20:11 
 */
@SpringBootApplication
@EnableDiscoveryClient //nacos注册
@EnableFeignClients
@MapperScan("com.ccd.kbms.mapper")
@ComponentScan(basePackages = {"com.ccd"})
public class KbmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(KbmsApplication.class, args);
    }
}
