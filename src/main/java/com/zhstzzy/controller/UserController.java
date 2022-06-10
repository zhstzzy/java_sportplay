package com.zhstzzy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhstzzy.model.R;
import com.zhstzzy.model.User;
import com.zhstzzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author : zhstzzy
 * @create 2022/5/30 18:43
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{currentPage}/{pageSize}")
    public R getUserList(@PathVariable Integer currentPage, @PathVariable Integer pageSize, String username) {
//        System.out.println(username);
        IPage<User> page = userService.getUsers(currentPage, pageSize, username);
        if (currentPage > page.getPages()) {
            page = userService.getUsers((int) page.getPages(), pageSize, username);
        }
        return R.ok(page,"查询成功！");
    }

    @GetMapping("/{id}")
    public R getUserById(@PathVariable Integer id){
        User user = userService.selectUserById(id);
        if (user == null) return R.error(400,"当前用户不存在");
        return R.ok(user.getUsername(),"用户已存在");
    }

    @GetMapping()
    public R getUserByUsername(String username){
        User user = userService.selectUserByUsername(username);
        if (user == null) return R.error(400,"当前用户不存在");
        return R.ok(user.getUsername(),"用户已存在");
    }


}
