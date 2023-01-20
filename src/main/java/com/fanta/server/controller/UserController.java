package com.fanta.server.controller;

import com.fanta.server.common.ResponseData;
import com.fanta.server.model.dto.users.UserLoginParam;
import com.fanta.server.model.vo.AccessTokenVo;
import com.fanta.server.service.IUserService;
import com.fanta.server.util.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

/**
 * 用户web层
 *
 * @author mmsong
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    private final IUserService iUserService;

    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @PostMapping("login")
    private ResponseData<AccessTokenVo> login(@Validated @RequestBody UserLoginParam param) {
        String accessToken = iUserService.loginByAccountAndPassword(param);
        Claims claims = JwtUtils.parseToken(accessToken);
        AccessTokenVo tokenVo = AccessTokenVo.builder()
                .accessToken(accessToken)
                .issueTime(claims.getIssuedAt())
                .expirationTime(claims.getExpiration()).build();
        return ResponseData.succeed(tokenVo);
    }

    @GetMapping("parse")
    private ResponseData<?> parseToken(String token) {
        Claims claims = JwtUtils.parseToken(token);
        Date expiration = claims.getExpiration();
        Date issuedAt = claims.getIssuedAt();
        HashMap<String, Object> map = new HashMap<>();
        map.put("expiration", expiration);
        map.put("issuedAt", issuedAt);
        return ResponseData.succeed(map);
    }
}
