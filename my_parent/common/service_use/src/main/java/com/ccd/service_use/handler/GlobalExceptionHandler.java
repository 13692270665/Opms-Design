package com.ccd.service_use.handler;

import com.ccd.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类
 * @Author ccd
 * @Date 2023/3/8 22:20
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    //指定出现什么异常执行这个方法
    @ExceptionHandler(Exception.class)
    public R error(Exception e) {
        log.error("执行了全局异常处理");
        e.printStackTrace();
        System.out.println("555");
        return R.error().message("执行了全局异常处理..");
    }

    //特定异常
    @ExceptionHandler(ArithmeticException.class)
    public R error(ArithmeticException e) {
        log.error("执行了ArithmeticException异常处理");
        e.printStackTrace();
        return R.error().message("执行了ArithmeticException异常处理..");
    }

}
