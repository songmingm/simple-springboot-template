package com.fanta.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fanta.server.model.dto.users.UserLoginParam;
import com.fanta.server.model.entity.SysUserEntity;

/**
 * 用户服务
 *
 * @author mmsong
 */
public interface IUserService extends IService<SysUserEntity> {

    String loginByAccountAndPassword(UserLoginParam param);
}
