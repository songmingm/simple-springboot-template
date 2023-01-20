package com.fanta.server.handler;

import com.fanta.server.common.ResponseData;
import com.fanta.server.enums.ErrorCodesEnum;
import com.fanta.server.util.WebUtils;
import com.google.gson.Gson;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 授权失败的处理
 *
 * @author mmsong
 */
@Component
public class AccessFiledHandler implements AccessDeniedHandler {

    private final Gson GSON = new Gson();

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ResponseData<String> data = ResponseData.fail(ErrorCodesEnum.NO_AUTH_ERROR);
        WebUtils.response(response, GSON.toJson(data));
    }
}
