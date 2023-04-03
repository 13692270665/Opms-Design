package com.ccd.opms.controller;


import com.ccd.utils.R;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author CCD
 * @since 2023-04-03
 */
@CrossOrigin
@Api(tags = "登录注册")
@RestController
@RequestMapping("/opms/user")
public class UserController {

    @PostMapping("login")
    public R login(){
        return R.ok().data("token","admin");
    }

    @GetMapping("info")
    public R info(){
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","http://t15.baidu.com/it/u=736139517,3841551240&fm=224&app=112&f=JPEG?w=500&h=500");
    }

}

