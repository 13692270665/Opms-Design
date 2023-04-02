package com.ccd.utils;/**
 * @author :ccd
 * @date : 2023/2/27 23:24
 */

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一结果返回对象
 * @Author ccd
 * @Date 2023/2/27 23:24
 */
@Data
public class R {
    private Boolean success;
    private Integer code;
    private String message;
    private Map<String, Object> data = new HashMap<String, Object>();

    //把构造方法私有
    private R() {}

    //成功
    public static R ok() {
        R r = new R();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS.getValue());
        r.setMessage("成功");
        return r;
    }

    //失败
    public static R error() {
        R r = new R();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR.getValue());
        r.setMessage("失败");
        return r;
    }

    //返回this，即谁调用返回谁，可用于链式编程
    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public R message(String message){
        this.setMessage(message);
        return this;
    }

    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    public R data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public R data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}
