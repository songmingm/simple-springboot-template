package com.fanta.server.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 响应码
 */
@AllArgsConstructor
@Getter
public enum ErrorCodesEnum {

    SUCCESS(0, "请求成功"),
    PARAMS_ERROR(40000, "请求参数错误"),
    NOT_LOGIN_ERROR(40100, "未登录"),
    NO_AUTH_ERROR(40101, "无权限"),
    NOT_FOUND_ERROR(40400, "请求数据不存在"),
    FORBIDDEN_ERROR(40300, "禁止访问"),
    SYSTEM_ERROR(50000, "系统内部异常"),
    OPERATION_ERROR(50001, "操作失败");

    /**
     * 状态码
     */
    private final int code;

    /**
     * 信息
     */
    private final String message;

}
