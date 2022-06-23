package com.zhstzzy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhstzzy.mapper.MenuMapper;
import com.zhstzzy.model.MainMenu;
import com.zhstzzy.model.User;
import com.zhstzzy.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author : zhstzzy
 * @create 2022/5/24 8:31
 */
@Service("menuService")
@Transactional
public class MenuServiceImpl extends ServiceImpl<MenuMapper,MainMenu> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<MainMenu> getMenus(User user) {
        return menuMapper.getMenus(user);
    }

    @Override
    public List<MainMenu> getAllMenus() {
        return menuMapper.getAllMenus();
    }
}
