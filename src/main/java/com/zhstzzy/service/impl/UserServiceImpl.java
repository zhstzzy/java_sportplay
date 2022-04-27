package com.zhstzzy.service.impl;

import com.zhstzzy.dao.UserDao;
import com.zhstzzy.model.R;
import com.zhstzzy.model.User;
import com.zhstzzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import static com.zhstzzy.model.RHttpStatusEnum.HTTP_NOT_FOUND;

/**
 * @Author : zhstzzy
 * @create 2022/4/27 19:43
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public R login(User user) {
        User userByUsernameAndPassword = dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        HashMap<String, Object> map = new HashMap<>();
        if (userByUsernameAndPassword != null) {
            map.put("username", user.getUsername());
            return R.ok(map,"登录成功");
        }
        return R.error(HTTP_NOT_FOUND.getCode(),"用户名或密码错误");
    }
}
