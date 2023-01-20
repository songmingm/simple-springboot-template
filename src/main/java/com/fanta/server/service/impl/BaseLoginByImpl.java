package com.fanta.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fanta.server.mapper.SysUserMapper;
import com.fanta.server.model.entity.SysUserEntity;

/**
 * @author mmsong
 */
public class BaseLoginByImpl {

    private final SysUserMapper sysUserMapper;

    public BaseLoginByImpl(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    /**
     * 通过用户账号查询用用信息
     *
     * @param account 用户账号
     * @return 用户信息
     */
    public SysUserEntity selectUserByAccount(String account) {
        // 1. 判断用户账号是否存在
        LambdaQueryWrapper<SysUserEntity> lambdaQuery = Wrappers.lambdaQuery(SysUserEntity.class);
        lambdaQuery.eq(SysUserEntity::getUserAccount, account);
        return this.sysUserMapper.selectOne(lambdaQuery);
    }
}
