package com.ccd.opms.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ccd.opms.entity.User;
import com.ccd.opms.entity.vo.RegisterVo;
import com.ccd.opms.mapper.UserMapper;
import com.ccd.opms.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ccd.service_use.handler.CcdException;
import com.ccd.utils.JwtUtils;
import com.ccd.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author CCD
 * @since 2023-04-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Override
    public String login(User user) {
        //获取手机号和密码
        String mobile = user.getMobile();
        String password = user.getPassword();
        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)) {
            throw new CcdException(20001, "手机号或密码为空，登陆失败");
        }
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile", mobile);
        User moblieUser = baseMapper.selectOne(wrapper);
        if (moblieUser == null) {
            throw new CcdException(20001, "该用户不存在，登录失败");
        }
        if (!MD5.encrypt(password).equals(moblieUser.getPassword())) {
            throw new CcdException(20001, "密码错误，登陆失败");
        }
        String token = JwtUtils.getJwtToken(moblieUser.getId(), moblieUser.getUsername());
        return token;
    }

    @Override
    public void register(RegisterVo registerVo) {
        //获取注册数据
        String code = registerVo.getCode();
        String mobile = registerVo.getMobile();
        String username = registerVo.getUsername();
        String password = registerVo.getPassword();
        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)
                || StringUtils.isEmpty(code) || StringUtils.isEmpty(username)) {
            throw new CcdException(20001, "注册信息不完整，注册失败");
        }
        String redisCode = redisTemplate.opsForValue().get(mobile);
        if (!redisCode.equals(code)) {
            throw new CcdException(20001, "验证码错误，注册失败");
        }
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile", mobile);
        Integer count = baseMapper.selectCount(wrapper);
        if (count > 0) {
            throw new CcdException(20001, "该手机已注册，注册失败");
        }
        //添加到数据库
        User user = new User();
        user.setMobile(mobile);
        user.setUsername(username);
        user.setPassword(MD5.encrypt(password));
        user.setAvatar("http://t15.baidu.com/it/u=736139517,3841551240&fm=224&app=112&f=JPEG?w=500&h=500");
        baseMapper.insert(user);
    }

    @Override
    public boolean send(Map<String, Object> param, String mobile) {
        if (StringUtils.isEmpty(mobile)) return false;

        DefaultProfile profile =
                DefaultProfile.getProfile("default");
        IAcsClient client = new DefaultAcsClient(profile);

        //设置相关固定的参数
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");

        //设置发送相关的参数
        request.putQueryParameter("PhoneNumbers", mobile); //手机号
        request.putQueryParameter("SignName", "阿里云短信测试"); //申请阿里云 签名名称
        request.putQueryParameter("TemplateCode", "SMS_154950909"); //申请阿里云 模板code
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(param)); //验证码数据，转换json数据传递

        try {
            //最终发送
            CommonResponse response = client.getCommonResponse(request);
            boolean success = response.getHttpResponse().isSuccess();
            return success;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
