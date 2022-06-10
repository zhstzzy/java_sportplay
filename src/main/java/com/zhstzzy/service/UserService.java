package com.zhstzzy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhstzzy.model.R;
import com.zhstzzy.model.User;

/**
 * @Author : zhstzzy
 * @create 2022/4/27 19:42
 */
public interface UserService extends IService<User> {
    R login(User user);

    IPage<User> getUsers(Integer currentPage, Integer pageSize, String username);

    User selectUserById(Integer id);

    User selectUserByUsername(String username);
}
