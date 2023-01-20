package com.fanta.server.common;

import com.fanta.server.enums.ErrorCodesEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * 通用返回类
 */
@Data
public class ResponseData<T> implements Serializable {

    private String type;
    private int status;
    private String message;
    private T data;

    /**
     * 响应成功有返回数据
     */
    public static <T> ResponseData<T> succeed(T data) {
        return renderData(ErrorCodesEnum.SUCCESS.getErrorCode(), ErrorCodesEnum.SUCCESS.getErrorType(), null, data);
    }

    /**
     * 响应成功无返回数据
     */
    public static <T> ResponseData<T> succeed() {
        return renderData(ErrorCodesEnum.SUCCESS.getErrorCode(), ErrorCodesEnum.SUCCESS.getErrorType(), null, null);
    }

    /**
     * 响应失败
     */
    public static <T> ResponseData<T> fail(ErrorCodesEnum errorCode) {
        return renderData(errorCode.getErrorCode(), errorCode.getErrorType(), null, null);
    }

    /**
     * 响应失败，自定义错误提示信息
     */
    public static ResponseData<String> fail(ErrorCodesEnum errorCode, String message) {
        return renderData(errorCode.getErrorCode(), errorCode.getErrorType(), message, null);
    }

    /**
     * 渲染返回数据
     */
    private static <T> ResponseData<T> renderData(int status, String type, String message, T data) {
        ResponseData<T> response = new ResponseData<T>();
        response.setStatus(status);
        response.setType(type);
        response.setMessage(message);
        response.setData(data);
        return response;
    }
}
