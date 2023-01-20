package com.fanta.server.config;

import com.fanta.server.common.IgnoreUrls;
import com.fanta.server.filter.JwtAuthenticationTokenFilter;
import com.fanta.server.handler.AccessFiledHandler;
import com.fanta.server.handler.AuthenticationFailedHandler;
import com.fanta.server.service.impl.LoginByAccountAndPasswordServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * security 授权配置
 *
 * @author mmsong
 */
@Configuration
public class SecurityConfig {

    private final IgnoreUrls ignoreUrls;
    private final AuthenticationFailedHandler authenticationFailedHandler;
    private final AccessFiledHandler accessFiledHandler;
    private final LoginByAccountAndPasswordServiceImpl loginByAccountAndPasswordService;
    private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;


    public SecurityConfig(IgnoreUrls ignoreUrls,
                          AuthenticationFailedHandler authenticationFailedHandler,
                          AccessFiledHandler accessFiledHandler,
                          LoginByAccountAndPasswordServiceImpl loginByAccountAndPasswordService,
                          JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter) {
        this.ignoreUrls = ignoreUrls;
        this.authenticationFailedHandler = authenticationFailedHandler;
        this.accessFiledHandler = accessFiledHandler;
        this.loginByAccountAndPasswordService = loginByAccountAndPasswordService;
        this.jwtAuthenticationTokenFilter = jwtAuthenticationTokenFilter;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.authorizeRequests();
        // 不需要保护的资源
        ignoreUrls.getUrls().forEach(url -> registry.antMatchers(url).permitAll());
        // 允许跨域请求的OPTIONS请求
        registry.antMatchers(HttpMethod.OPTIONS).permitAll();
        // 任何请求需要身份认证
        registry.and()
                .authorizeRequests().anyRequest().authenticated()
                // 关闭跨站请求防护及不使用session
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
                .and()
                // 允许跨域访问
                .cors()
                .and()
                .httpBasic().disable()
                .formLogin().disable()
                .logout().disable()
//                 设置失败处理器
                .exceptionHandling()
                .authenticationEntryPoint(authenticationFailedHandler)
                .accessDeniedHandler(accessFiledHandler)
                .and()
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
        ;
        return http.build();
    }

    /**
     * 认证管理器，用户登录认证
     */
    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(daoAuthenticationProvider());
    }

    /**
     * 验证方式：用户名和密码
     */
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(loginByAccountAndPasswordService);
        return daoAuthenticationProvider;
    }

    /**
     * 设置默认的加密方式（强hash方式加密）
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
