package com.ccd.opms.controller;


import com.ccd.opms.entity.User;
import com.ccd.opms.entity.vo.RegisterVo;
import com.ccd.opms.service.UserService;
import com.ccd.opms.utils.RandomUtil;
import com.ccd.utils.JwtUtils;
import com.ccd.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
    @Autowired
    RedisTemplate<String,String> redisTemplate;

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

    @ApiOperation("发短信")
    @GetMapping("send")
    public R sendSms(@RequestParam("mobile") String mobile){
        // 先从redis中获取
        String code = redisTemplate.opsForValue().get(mobile);
        if (!StringUtils.isEmpty(code)){
            return R.ok();
        }
        // 否则随机生成
        code = RandomUtil.getFourBitRandom();
        Map<String, Object> param = new HashMap<>();
        param.put("code", code);
        //调用发送短信方法
        boolean isSend = userService.send(param,mobile);
        if (isSend){
            //发送成功，放入redis
            redisTemplate.opsForValue().set(mobile, code,1, TimeUnit.MINUTES);
            return R.ok();
        }else {
            return R.error().message("短信发送失败！");
        }
    }

}

