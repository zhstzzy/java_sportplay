package com.zhstzzy.utils;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.UUID;

/**
 * jwt 工具类
 */
public class JwtUtil {

    // 有效期
    private static final long time = 86400000;
    // 签名
    private static final String signature = "UUID.randomUUID().toString()";

    /**
     * 创建token的方法
     * @return 返回一个token
     */
    public static String createToken(Integer id,String username,String role){
        JwtBuilder builder = Jwts.builder();
        return builder
                // header
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                // payload
                .claim("userId", id)
                .claim("username", username)
                .claim("role", role)
                .setSubject("admin-check")
                .setExpiration(new Date(System.currentTimeMillis() + time))
                .setId(UUID.randomUUID().toString())
                // signature
                .signWith(SignatureAlgorithm.HS256, signature)
                .compact();
    }


    /**
     * 校验token是否过期
     */
    public static boolean checkToken(String token){
        if (token == null){
            return false;
        }
        JwtParser parser = Jwts.parser();
        try {
            Jws<Claims> claimsJws = parser.setSigningKey(signature)
                    .parseClaimsJws(token);
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
            // 如果token 失效
            return false;
        }
        return true;
    }

    /**
     * 解析token
     */
    public static Claims getToken(String token){
        try {
            if (token != null){
                JwtParser parser = Jwts.parser();
                Jws<Claims> claimsJws = parser.setSigningKey(signature)
                        .parseClaimsJws(token);
                return claimsJws.getBody();
            }
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
            // 如果token 失效
            return null;
        }
        return null;
    }

}
