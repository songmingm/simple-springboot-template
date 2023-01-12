package com.fanta.server.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 接口信息表
 *
 * @author mmsong
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "interface_info")
@Data
public class SysInterfaceEntity extends BaseTimeEntity {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String method;
    private String description;
    private String requestUrl;
    private String requestParams;
    private String responseHeader;
    private int status;
    @TableLogic
    private int isDelete;
}
