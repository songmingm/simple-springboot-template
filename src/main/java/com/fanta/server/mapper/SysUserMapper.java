package com.fanta.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fanta.server.model.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息mapper
 *
 * @author mmsong
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUserEntity> {
}
