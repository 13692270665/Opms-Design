package com.ccd.opms.service.impl;

import com.ccd.opms.entity.User;
import com.ccd.opms.mapper.UserMapper;
import com.ccd.opms.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
