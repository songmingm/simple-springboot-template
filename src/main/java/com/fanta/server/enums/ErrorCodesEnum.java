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
    PARAMS_ERROR(-40, "请求参数错误"),
    NOT_LOGIN_ERROR(-50, "未登录"),
    NO_AUTH_ERROR(-51, "无权限访问"),
    NOT_FOUND_ERROR(-10, "请求数据不存在"),
    FORBIDDEN_ERROR(-1, "禁止访问"),
    SYSTEM_ERROR(-60, "系统内部异常"),
    OPERATION_ERROR(-200, "操作失败"),
    SQL_ERROR(-80, "数据库服务异常"),


    /**
     * jwt 异常(3)
     */
    JWT_PAST_ERROR(-300, "验证信息已过期"),

    JWT_SIGN_ERROR(-301, "令牌签发异常"),

    JWT_UN_SUPPORT_ERROR(-302, "不受支持的令牌信息"),

    JWT_PARSE_ERROR(-303, "令牌解析异常"),

    /**
     * 用户相关异常(4)
     */
    AUTH_ERROR(-300, "认证失败"),

    USER_NOT_EXIST(-301, "用户不存在"),

    PASSWORD_AUTH_ERROR(-302, "密码验证失败");

    /**
     * 状态码
     */
    private final int errorCode;

    /**
     * 错误类型
     */
    private final String errorType;

}
