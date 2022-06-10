package com.zhstzzy.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.zhstzzy.model.User;
import com.zhstzzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : zhstzzy
 * @create 2022/6/6 18:09
 */
@Component
public class JwtUitls {

    public String getToken(User user, long time) {
        Date start = new Date();//token起始时间
        long currentTime = System.currentTimeMillis() + time;
        Date end = new Date(currentTime);//token结束时间
        String token = "";
        token = JWT.create()
                .withAudience(user.getId().toString()) //存放接收方的信息
                .withIssuedAt(start)//token开始时间
                .withExpiresAt(end)//token存活截止时间
                .sign(Algorithm.HMAC256(user.getPassword()));//加密
        return token;
    }
}