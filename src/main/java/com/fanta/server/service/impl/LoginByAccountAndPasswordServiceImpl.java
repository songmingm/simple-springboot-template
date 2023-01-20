package com.fanta.server.service.impl;

import com.fanta.server.common.LoginUser;
import com.fanta.server.enums.ErrorCodesEnum;
import com.fanta.server.exception.BusinessException;
import com.fanta.server.mapper.SysUserMapper;
import com.fanta.server.model.entity.SysUserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * 用户名与密码登录验证方式
 *
 * @author mmsong
 */
@Service
public class LoginByAccountAndPasswordServiceImpl extends BaseLoginByImpl implements UserDetailsService {

    public LoginByAccountAndPasswordServiceImpl(SysUserMapper sysUserMapper) {
        super(sysUserMapper);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUserEntity sysUser = super.selectUserByAccount(username);
        if (ObjectUtils.isEmpty(sysUser))
            throw new BusinessException(ErrorCodesEnum.USER_NOT_EXIST,"未查询到用户相关信息");
        Long userId = sysUser.getId();
        // TODO 查询用户角色信息和权限信息
        return new LoginUser(sysUser, null, null);
    }


}
