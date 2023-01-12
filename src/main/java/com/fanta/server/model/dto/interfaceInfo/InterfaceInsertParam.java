package com.fanta.server.model.dto.interfaceInfo;

import lombok.Data;

import java.io.Serializable;

/**
 * 新增接口参数
 *
 * @author mmsong
 */
@Data
public class InterfaceInsertParam implements Serializable {

    private String name;
    private String method;
    private String description;
    private String requestUrl;
    private String requestParams;
    private String responseHeader;
}
