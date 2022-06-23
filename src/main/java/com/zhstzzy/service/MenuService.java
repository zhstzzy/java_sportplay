package com.zhstzzy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhstzzy.model.MainMenu;
import com.zhstzzy.model.User;

import java.util.List;

/**
 * @Author : zhstzzy
 * @create 2022/5/24 8:30
 */
public interface MenuService extends IService<MainMenu> {

    List<MainMenu> getMenus(User user);
    List<MainMenu> getAllMenus();




}
