package com.fanta.server.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 返回的认证信息视图
 *
 * @author mmsong
 */
@ApiModel("认证信息")
@Data
@Builder
public class AccessTokenVo implements Serializable {

    @ApiModelProperty("令牌信息")
    private String accessToken;

    @ApiModelProperty("失效时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expirationTime;

    @ApiModelProperty("签发时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date issueTime;

}
