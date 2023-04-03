package com.ccd.opms.service;

import com.ccd.opms.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ccd.opms.entity.vo.RegisterVo;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author CCD
 * @since 2023-04-03
 */
public interface UserService extends IService<User> {

    String login(User user);

    void register(RegisterVo registerVo);
}
