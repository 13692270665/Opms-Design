package com.ccd.service_use.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *
 * @Author ccd
 * @Date 2023/3/8 11:29
 */
@Component
public class AutoFillHandler implements MetaObjectHandler {

    //添加时执行
    @Override
    public void insertFill(MetaObject metaObject) {
        //pojo属性名而非表列名
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }

    //修改时执行
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }

}
