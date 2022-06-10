package com.zhstzzy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhstzzy.dao.UserMapper;
import com.zhstzzy.model.R;
import com.zhstzzy.model.User;
import com.zhstzzy.service.UserService;
import org.apache.logging.log4j.util.Strings;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper dao;

    @Override
    public R login(User user) {
        if (user != null) {
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            Map<String, Object> params = new HashMap<>();
            params.put("username", user.getUsername());
            params.put("password", user.getPassword());
            params.put("state", 1);
            wrapper.allEq(params, false);
            User loginUser = dao.selectOne(wrapper);
            HashMap<String, Object> map = new HashMap<>();
            if (loginUser != null) {
                map.put("username", loginUser.getUsername());
                return R.ok(map, "登录成功!");
            }
        }
        return R.error(HTTP_NOT_FOUND.getCode(), "用户名或密码错误!");


//        User userByUsernameAndPassword = dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
//        HashMap<String, Object> map = new HashMap<>();
//        if (userByUsernameAndPassword != null) {
//            map.put("username", user.getUsername());
//            return R.ok(map,"登录成功");
//        }
//        return R.error(HTTP_NOT_FOUND.getCode(),"用户名或密码错误");
    }

    @Override
    public IPage<User> getUsers(Integer currentPage, Integer pageSize, String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (Strings.isNotEmpty(username)) {
            wrapper.like("username", username);
        }
        IPage<User> usersPage = new Page<>(currentPage, pageSize);
        dao.selectPage(usersPage, wrapper);
        return usersPage;
    }

    @Override
    public User selectUserById(Integer id) {
        if (id==null) return null;
        return dao.selectById(id);
    }

    @Override
    public User selectUserByUsername(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (Strings.isNotEmpty(username)) {
            wrapper.eq("username",username);
            return dao.selectOne(wrapper);
        }
        return null;
    }

}
