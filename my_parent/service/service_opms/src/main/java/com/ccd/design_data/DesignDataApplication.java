package com.ccd.design_data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author :ccd
 * @date : 2023/2/23 20:11 
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.ccd"})
public class DesignDataApplication {
    public static void main(String[] args) {
        SpringApplication.run(DesignDataApplication.class, args);
    }
}
