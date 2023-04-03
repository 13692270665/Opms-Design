package com.ccd.opms.controller;


import com.ccd.opms.entity.User;
import com.ccd.opms.service.UserService;
import com.ccd.utils.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService userService;

    @PostMapping("login")
    public R login(@RequestBody User user){
        //返回token值，使用jwt生成
        String token = userService.login(user);
        return R.ok().data("token",token);
    }

    @GetMapping("info")
    public R info(){
        return R.ok().data("name","admin").data("avatar","http://t15.baidu.com/it/u=736139517,3841551240&fm=224&app=112&f=JPEG?w=500&h=500");
    }

}

