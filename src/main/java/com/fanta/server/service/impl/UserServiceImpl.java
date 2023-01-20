package com.fanta.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fanta.server.common.LoginUser;
import com.fanta.server.mapper.SysUserMapper;
import com.fanta.server.model.dto.users.UserLoginParam;
import com.fanta.server.model.entity.SysUserEntity;
import com.fanta.server.service.IUserService;
import com.fanta.server.util.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户服务实现
 *
 * @author mmsong
 */
@Service
public class UserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements IUserService {


    private final AuthenticationManager authenticationManager;

    public UserServiceImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public String loginByAccountAndPassword(UserLoginParam param) {
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(param.getUserAccount(), param.getUserPassword());
        Authentication authenticate = authenticationManager.authenticate(auth);
        LoginUser principal = (LoginUser) authenticate.getPrincipal();
        String accessToken = JwtUtils.createToken(this.setPayload(principal.getUser()));
        return accessToken;
    }

    /**
     * 存放用户的jwt载荷信息
     */
    private Map<String, Object> setPayload(SysUserEntity sysUser) {
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("userid", sysUser.getId());
        claims.put("userAccount", sysUser.getUserAccount());
        claims.put("loginTime", new Date());
        return claims;
    }
}
