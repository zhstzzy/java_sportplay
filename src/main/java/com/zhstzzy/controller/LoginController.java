package com.zhstzzy.controller;

import com.zhstzzy.entity.R;
import com.zhstzzy.model.User;
import com.zhstzzy.service.UserService;
import com.zhstzzy.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author : zhstzzy
 * @create 2022/4/27 18:55
 */
@RestController
@RequestMapping
@Log4j2
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public R login(@RequestBody User user) {
        log.info("{} 正在登录", user.getUsername());
        return userService.login(user);
    }

    @PostMapping("/isLogin")
    public R isLogin(@CookieValue(value = "token") String token) {
        log.info("通过token验证登录信息是否有效");
        if (JwtUtil.checkToken(token)) {
            Claims token1 = JwtUtil.getToken(token);
            User user1 = new User();
            user1.setId(token1.get("id", Integer.class));
            user1.setUsername(token1.get("username", String.class));
            user1.setRole(token1.get("role", String.class));
            log.info("token有效");
            return R.ok(user1, "token有效");
        }
        log.info("token 无效");
        return R.error(400, "token 无效");
    }
}
