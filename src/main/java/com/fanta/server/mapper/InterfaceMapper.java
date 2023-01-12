package com.fanta.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fanta.server.model.entity.SysInterfaceEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 接口信息mapper
 *
 * @author mmsong
 */
@Mapper
public interface InterfaceMapper extends BaseMapper<SysInterfaceEntity> {
}
