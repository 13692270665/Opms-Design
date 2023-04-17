package com.ccd.temp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author :ccd
 * @date : 2023/4/9 14:19
 */
@SpringBootApplication
@EnableDiscoveryClient //nacos注册
@EnableFeignClients
@MapperScan("com.ccd.temp.mapper")
@ComponentScan(basePackages = {"com.ccd"})
public class TempApplication {
    public static void main(String[] args) {
        SpringApplication.run(TempApplication.class, args);
    }
}
