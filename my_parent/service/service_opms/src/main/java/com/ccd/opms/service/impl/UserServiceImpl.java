package com.ccd.opms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ccd.opms.entity.User;
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
}
