package com.ccd.opms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ccd.opms.entity.User;
import com.ccd.opms.entity.vo.RegisterVo;
import com.ccd.opms.mapper.UserMapper;
import com.ccd.opms.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ccd.service_use.handler.CcdException;
import com.ccd.utils.JwtUtils;
import com.ccd.utils.MD5;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    @Override
    public String login(User user) {
        //获取手机号和密码
        String mobile = user.getMobile();
        String password = user.getPassword();
        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)) {
            throw new CcdException(20001, "手机号或密码为空，登陆失败");
        }
        //判断手机号是否正确
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile", mobile);
        User moblieUser = baseMapper.selectOne(wrapper);
        //判断查询对象是否为空
        if (moblieUser == null) {
            throw new CcdException(20001, "该用户不存在，登录失败");
        }
        //判断密码(数据库中密码为加密形式，因此要将输入密码进行加密后再比较)
        if (!MD5.encrypt(password).equals(moblieUser.getPassword())) {
            throw new CcdException(20001, "密码错误，登陆失败");
        }
        //登陆成功,生成token
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
        //非空判断
        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)
                || StringUtils.isEmpty(code) || StringUtils.isEmpty(username)) {
            throw new CcdException(20001, "注册信息不完整，注册失败");
        }
        //判断验证码
//        String redisCode = redisTemplate.opsForValue().get(mobile);
//        if (!redisCode.equals(code)) {
//            throw new CcdException(20001, "验证码错误，注册失败");
//        }
        //判断手机号是否重复
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
}
