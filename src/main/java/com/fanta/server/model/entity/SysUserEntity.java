package com.fanta.server.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 用户
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_user")
@Data
public class SysUserEntity extends BaseTimeEntity {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 用户角色: user, admin
     */
    private String userRole;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}