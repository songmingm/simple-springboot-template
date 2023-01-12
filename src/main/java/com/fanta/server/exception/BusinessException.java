package com.fanta.server.exception;


import com.fanta.server.enums.ErrorCodesEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 自定义异常类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException {

    private int code;
    private final String message;

    public BusinessException() {
        this.message = super.getMessage();
    }

    public BusinessException(String message) {
        this.message = message;
    }

    public BusinessException(ErrorCodesEnum errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
}
