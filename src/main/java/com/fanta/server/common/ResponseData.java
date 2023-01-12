package com.fanta.server.common;

import com.fanta.server.enums.ErrorCodesEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * 通用返回类
 */
@Data
public class ResponseData<T> implements Serializable {

    private int code;

    private T data;

    private String message;

    /**
     * 响应成功有返回数据
     */
    public static <T> ResponseData<T> succeed(T data) {
        return renderData(ErrorCodesEnum.SUCCESS.getCode(), ErrorCodesEnum.SUCCESS.getMessage(), data);
    }

    /**
     * 响应成功无返回数据
     */
    public static <T> ResponseData<T> succeed() {
        return renderData(ErrorCodesEnum.SUCCESS.getCode(), ErrorCodesEnum.SUCCESS.getMessage(), null);
    }

    /**
     * 响应失败
     */
    public static <T> ResponseData<T> fail(ErrorCodesEnum errorCode) {
        return renderData(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 响应失败
     */
    public static <T> ResponseData<T> fail(int code, String message) {
        return renderData(code, message, null);
    }

    /**
     * 渲染返回数据
     */
    private static <T> ResponseData<T> renderData(int code, String message, T data) {
        ResponseData<T> response = new ResponseData<T>();
        response.setCode(code);
        response.setMessage(message);
        response.setData(data);
        return response;
    }
}
