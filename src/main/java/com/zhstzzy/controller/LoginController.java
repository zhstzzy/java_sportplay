package com.zhstzzy.controller;

import com.zhstzzy.model.R;
import com.zhstzzy.model.Users;
import com.zhstzzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author : zhstzzy
 * @create 2022/4/27 18:55
 */
@RestController
@RequestMapping
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public R login(@RequestBody Users user){
        System.out.println(user);
        R login = userService.login(user);
        return login;
    }
}
