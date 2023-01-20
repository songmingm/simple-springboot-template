package com.fanta.server.handler;

import com.fanta.server.common.ResponseData;
import com.fanta.server.enums.ErrorCodesEnum;
import com.fanta.server.util.WebUtils;
import com.google.gson.Gson;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证失败处理器
 *
 * @author mmsong
 */
@Component
public class AuthenticationFailedHandler implements AuthenticationEntryPoint {

    private final Gson GSON = new Gson();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResponseData<String> data;
        if (authException instanceof BadCredentialsException)
            data = ResponseData.fail(ErrorCodesEnum.PASSWORD_AUTH_ERROR, authException.getMessage());
        else
            data = ResponseData.fail(ErrorCodesEnum.AUTH_ERROR, authException.getMessage());
        WebUtils.response(response, GSON.toJson(data));
    }
}
