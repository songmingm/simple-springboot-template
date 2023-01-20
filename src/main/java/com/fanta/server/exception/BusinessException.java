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

    private ErrorCodesEnum error;
    private String message;

    public BusinessException(ErrorCodesEnum error, String message) {
        this.error = error;
        this.message = message;
    }

    public BusinessException(ErrorCodesEnum error) {
        this.error = error;
    }
}
