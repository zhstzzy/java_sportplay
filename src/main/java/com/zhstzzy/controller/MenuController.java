package com.zhstzzy.controller;

import com.zhstzzy.model.MainMenu;
import com.zhstzzy.entity.R;
import com.zhstzzy.model.User;
import com.zhstzzy.service.MenuService;
import com.zhstzzy.service.UserService;
import com.zhstzzy.utils.JwtUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @Author : zhstzzy
 * @create 2022/5/24 8:34
 */
@RestController
@RequestMapping("/menus")
@Log4j2
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private UserService userService;

    @GetMapping
    public R getMenus(String username, @CookieValue(value = "token", required = false) String token) {
        log.info("查询菜单中");
        User user = null;
        if (username.equals("") && token != null) {
            Integer userId = JwtUtil.getToken(token).get("userId", Integer.class);
            user = userService.selectUserById(userId);
        } else {
            user = userService.selectUserByUsername(username);
        }
        List<MainMenu> menus = null;
        if (user.getUsername().equals("admin")) {
            menus = menuService.getAllMenus();
        } else {
            menus = menuService.getMenus(user);
        }
        if (menus != null) {
            HashMap<String, Object> res = new HashMap<>();
            res.put("menus", menus);
            return R.ok(res, "查询菜单列表成功!");
        }
        return R.error(404, "查询菜单列表失败!");
    }

}
