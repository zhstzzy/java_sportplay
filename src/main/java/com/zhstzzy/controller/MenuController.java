package com.zhstzzy.controller;

import com.zhstzzy.model.R;
import com.zhstzzy.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        System.out.println("访问成功！");
        return menuService.getMenus();
    }

}
