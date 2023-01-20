package com.fanta.server.model.dto.users;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 用户登录参数
 *
 * @author mmsong
 */
@ApiModel("用户登录参数")
@Data
public class UserLoginParam {

    @ApiModelProperty("用户账号")
    @NotBlank(message = "用户账号不能为空")
    private String userAccount;

    @ApiModelProperty("用户密码")
    @NotBlank(message = "用户密码不能为空")
    private String userPassword;
}
