package com.zhstzzy.controller;

import com.zhstzzy.model.MainMenu;
import com.zhstzzy.model.R;
import com.zhstzzy.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public R getMenus(){
        List<MainMenu> menus = menuService.getMenus();
        if (menus != null) {
            HashMap<String, Object> res = new HashMap<>();
            res.put("menus", menus);
            return R.ok(res, "查询菜单列表成功!");
        }
        return R.error(404,"查询菜单列表失败!");
    }

}
