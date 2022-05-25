package com.zhstzzy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhstzzy.dao.UserDao;
import com.zhstzzy.model.R;
import com.zhstzzy.model.Users;
import com.zhstzzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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
    public R login(Users user) {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        Map<String,Object> params = new HashMap<>();
        params.put("username",user.getUsername());
        params.put("password",user.getPassword());
        params.put("state",1);
        wrapper.allEq(params,false);
        Users loginUser = dao.selectOne(wrapper);
        HashMap<String, Object> map = new HashMap<>();
        if (loginUser != null) {
            map.put("username", loginUser.getUsername());
            return R.ok(map, "登录成功");
        }
        return R.error(HTTP_NOT_FOUND.getCode(), "用户名或密码错误");
//        User userByUsernameAndPassword = dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
//        HashMap<String, Object> map = new HashMap<>();
//        if (userByUsernameAndPassword != null) {
//            map.put("username", user.getUsername());
//            return R.ok(map,"登录成功");
//        }
//        return R.error(HTTP_NOT_FOUND.getCode(),"用户名或密码错误");
    }
}
