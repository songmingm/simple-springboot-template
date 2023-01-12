package com.fanta.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fanta.server.mapper.InterfaceMapper;
import com.fanta.server.model.entity.SysInterfaceEntity;
import com.fanta.server.service.IInterfaceService;
import org.springframework.stereotype.Service;

/**
 * 接口服务实现层
 *
 * @author mmsong
 */
@Service
public class InterfaceImpl extends ServiceImpl<InterfaceMapper, SysInterfaceEntity>
        implements IInterfaceService {
}
