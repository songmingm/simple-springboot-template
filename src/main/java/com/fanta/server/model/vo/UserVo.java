package com.fanta.server.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户视图
 */
@ApiModel("用户信息")
@Data
public class UserVo implements Serializable {

    @ApiModelProperty("用户ID")
    private Long id;

    @ApiModelProperty("用户昵称")
    private String username;

    @ApiModelProperty("账号")
    private String userAccount;

    @ApiModelProperty("用户头像")
    private String userAvatar;

    @ApiModelProperty("用户性别")
    private Integer userGender;

    @ApiModelProperty("用户角色")
    private String userRole;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;
}