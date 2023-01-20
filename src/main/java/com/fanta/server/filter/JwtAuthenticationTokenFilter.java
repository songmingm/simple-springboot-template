package com.fanta.server.filter;

import com.fanta.server.util.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 认证拦截未携带令牌信息的请求
 *
 * @author mmsong
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    public final String ACCESS_TOKEN = "accessToken";

    /**
     * 获取请求头令牌信息
     * <p>
     * 未携带令牌信息放行，由后面的过滤器执行
     * <p>
     * UsernamePasswordAuthenticationToken认证处理代码不执行，认证无法通过
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String accessToken = request.getHeader(ACCESS_TOKEN);
        if (StringUtils.hasText(accessToken)) {
            Claims claims = JwtUtils.parseToken(accessToken);
            if (!ObjectUtils.isEmpty(claims)) {
                // 获取redis中的用户信息，redis信息为空时，未登录
                // 注意：这里当登录成功后再次登录时，会携带token，此时不会走自定义登录逻辑
            }
        }
        filterChain.doFilter(request, response);
    }
}
