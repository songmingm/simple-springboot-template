package com.fanta.server.util;

import com.fanta.server.enums.ErrorCodesEnum;
import com.fanta.server.exception.BusinessException;
import io.jsonwebtoken.*;

import java.util.Date;
import java.util.Map;

/**
 * jwt工具类
 *
 * @author mmsong
 */
public class JwtUtils {

    /**
     * 令牌秘钥
     */
    private final static String SECRET = "fanya-api-server";

    /**
     * 过期时间(分钟)
     */
    private static final int TIME_OUT_MIN = 30;

    private static final int MIN = 1000 * 60;

    /**
     * 生成jwt
     *
     * @param claims 令牌承载信息
     * @return token 认证令牌
     */
    public static String createToken(Map<String, Object> claims) {
        // Id 用户重要信息 需要加密
        return Jwts.builder()
                // 存储用户信息
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                // 设置过期时间
                .setExpiration(new Date(System.currentTimeMillis() + MIN * TIME_OUT_MIN))
                // 设置当前时间
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .compact();
    }

    /**
     * 解析令牌信息
     *
     * @param accessToken token令牌
     * @return 数据声明
     */
    public static Claims parseToken(String accessToken) {
        try {
            return Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(accessToken)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw new BusinessException(ErrorCodesEnum.JWT_PAST_ERROR, e.getMessage());
        } catch (UnsupportedJwtException e) {
            throw new BusinessException(ErrorCodesEnum.JWT_UN_SUPPORT_ERROR, e.getMessage());
        } catch (SignatureException e) {
            throw new BusinessException(ErrorCodesEnum.JWT_SIGN_ERROR, e.getMessage());
        } catch (Exception e) {
            throw new BusinessException(ErrorCodesEnum.JWT_PARSE_ERROR, e.getMessage());
        }
    }

    /**
     * 从token中检查过期时间
     */
    public static boolean isExpiration(String accessToken) {
        Date expirationTime = parseToken(accessToken).getExpiration();
        return expirationTime.before(new Date());
    }
}
