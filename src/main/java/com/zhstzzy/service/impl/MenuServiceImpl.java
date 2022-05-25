package com.zhstzzy.service.impl;

import com.zhstzzy.dao.MenuDao;
import com.zhstzzy.model.MainMenu;
import com.zhstzzy.model.R;
import com.zhstzzy.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author : zhstzzy
 * @create 2022/5/24 8:31
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public R getMenus() {
        List<MainMenu> menus = menuDao.getMenus();
        if (menus != null) {
            HashMap<String, Object> res = new HashMap<>();
            res.put("menus", menus);
//        System.out.println(res);
            return R.ok(res, "查询菜单列表成功!");
        }
        return R.error(404,"查询菜单列表失败!");
    }
}
