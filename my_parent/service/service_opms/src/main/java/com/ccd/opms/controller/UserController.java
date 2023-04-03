package com.ccd.opms.controller;


import com.ccd.opms.entity.User;
import com.ccd.opms.entity.vo.RegisterVo;
import com.ccd.opms.service.UserService;
import com.ccd.utils.JwtUtils;
import com.ccd.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

    @ApiOperation("登录")
    @PostMapping("login")
    public R login(@RequestBody User user){
        return R.ok().data("token",userService.login(user));
    }

    @ApiOperation("注册")
    @PostMapping("register")
    public R register(@RequestBody RegisterVo registerVo) {
        userService.register(registerVo);
        return R.ok();
    }

    @ApiOperation("用token获取用户信息")
    @GetMapping("info")
    public R info(@RequestParam("token") String token){
        return R.ok().data("user",userService.getById(JwtUtils.getMemberIdByJwtToken(token)));
    }

}

