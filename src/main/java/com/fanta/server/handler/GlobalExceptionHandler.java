package com.fanta.server.handler;

import com.fanta.server.enums.ErrorCodesEnum;
import com.fanta.server.exception.BusinessException;
import com.fanta.server.common.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.Objects;

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
    public ResponseData<String> businessExceptionHandler(BusinessException e) {
        e.printStackTrace();
        LOGGER.error("businessException: {}", e.getMessage());
        return ResponseData.fail(e.getError(), e.getMessage());
    }

    /**
     * 数据库异常
     */
    @ExceptionHandler(SQLException.class)
    public ResponseData<String> sqlErrorHandler(SQLException e) {
        e.printStackTrace();
        LOGGER.error("sqlException：{}", e.getMessage());
        return ResponseData.fail(ErrorCodesEnum.SQL_ERROR, e.getMessage());
    }

    /**
     * 参数校验异常
     */
    @ExceptionHandler(BindException.class)
    public ResponseData<String> paramErrorExceptionHandler(BindException e) {
        e.printStackTrace();
        BindingResult bindingResult = e.getBindingResult();
        String message = Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage();
        LOGGER.error("bindException: {}", e.getMessage());
        return ResponseData.fail(ErrorCodesEnum.PARAMS_ERROR, message);
    }

//    /**
//     * 运行异常
//     */
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseData<?> runtimeExceptionHandler(RuntimeException e) {
//        e.printStackTrace();
//        LOGGER.error("runtimeException:{}", e.getMessage());
//        return ResponseData.fail(ErrorCodesEnum.SYSTEM_ERROR, e.getMessage());
//    }
}
