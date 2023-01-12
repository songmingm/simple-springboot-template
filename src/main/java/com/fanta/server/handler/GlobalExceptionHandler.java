package com.fanta.server.handler;

import com.fanta.server.enums.ErrorCodesEnum;
import com.fanta.server.exception.BusinessException;
import com.fanta.server.common.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 自定义业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseData<?> businessExceptionHandler(BusinessException e) {
        LOGGER.error("businessException: " + e.getMessage(), e);
        return ResponseData.fail(e.getCode(), e.getMessage());
    }

    /**
     * 运行异常
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseData<?> runtimeExceptionHandler(RuntimeException e) {
        LOGGER.error("runtimeException", e);
        return ResponseData.fail(ErrorCodesEnum.SYSTEM_ERROR);
    }
}
