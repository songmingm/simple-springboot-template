package com.fanta.server.model.dto.interfaces;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 新增接口参数
 *
 * @author mmsong
 */
@Data
public class InterfaceInsertParam implements Serializable {

    @NotBlank(message = "接口名称不能为空")
    private String name;

    @NotBlank(message = "接口请求方式不能为空")
    private String method;

    private String description;

    @NotBlank(message = "接口请求地址不能为空")
    private String requestUrl;

    private String requestParams;

    private String responseHeader;
}
