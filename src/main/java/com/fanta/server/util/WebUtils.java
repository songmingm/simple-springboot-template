package com.fanta.server.util;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * http 响应
 *
 * @author mmsong
 */
public class WebUtils {

    private final static String Encoding = "application/json;charset=UTF-8";

    public static <T> void response(HttpServletResponse response, String data) {
        response.setContentType(Encoding);
        try {
            PrintWriter writer = response.getWriter();
            writer.write(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
