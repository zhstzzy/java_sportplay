package com.zhstzzy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhstzzy.entity.R;
import com.zhstzzy.entity.RHttpStatusEnum;
import com.zhstzzy.entity.Register;
import com.zhstzzy.model.Role;
import com.zhstzzy.model.User;
import com.zhstzzy.service.RoleService;
import com.zhstzzy.service.UserService;
import com.zhstzzy.utils.JwtUtil;
import com.zhstzzy.utils.MD5Utils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author : zhstzzy
 * @create 2022/5/30 18:43
 */
@RestController
@RequestMapping("/user")
@Log4j2
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/{currentPage}/{pageSize}")
    public R getUserList(@PathVariable Integer currentPage, @PathVariable Integer pageSize, String username) {
//        System.out.println(username);
        IPage<User> page = userService.getUsers(currentPage, pageSize, username);
        if (currentPage > page.getPages()) {
            page = userService.getUsers((int) page.getPages(), pageSize, username);
        }
        return R.ok(page, "查询成功！");
    }

    @GetMapping("/{id}")
    public R getUserById(@PathVariable(required = false) Integer id, @CookieValue(value = "token", required = false) String token) {
        log.info("根据id查询用户");
        if ( token != null && id == null) {
            if (JwtUtil.checkToken(token)) {
                id = JwtUtil.getToken(token).get("userId", Integer.class);
            }
        }
        User user = userService.selectUserById(id);
        if (user == null) return R.error(400, "当前用户不存在");
        return R.ok(user, "用户已存在");
    }

    @GetMapping()
    public R getUserByUsername(String username) {
        log.info("正在根据用户名查询用户");
        User user = userService.selectUserByUsername(username);
        if (user == null) return R.error(400, "当前用户不存在");
        return R.ok(user, "用户已存在");
    }

    @PostMapping
    public R updateUserState(@RequestBody User user) {
        if (userService.updateState(user)) {
            return R.ok("激活成功");
        }
        return R.error(400, "取消激活");
    }

    @GetMapping("/email")
    public R sendEmail(@RequestParam("to") String to, @RequestParam("text") String text, HttpServletRequest request) {
        if (!to.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")) {
            return R.error(500, "邮箱不正确");
        }
        //随机生成6位验证码
        String code = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
        log.info("验证码为 {} ", code);

        //保存到 session 只保存10分钟
        HttpSession session = request.getSession();
        session.setAttribute(to, code);
        session.setMaxInactiveInterval(10 * 60);
        userService.sendMail(text, code, to);
        return R.ok("验证码发送成功");
    }

    //修改邮箱
    @PostMapping("/email")
    public R changeEmail(@RequestBody Register change, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute(change.getEmail());
        if (code.equals(change.getCode())) {
            User user = new User();
            user.setId(change.getId());
            user.setEmail(change.getEmail());
            if (userService.updateUser(user)) {
                return R.ok("修改邮箱成功！");
            }
            return R.error(400, "注册失败");
        }
        return R.error(400, "邮箱验证失败");
    }

    @PostMapping("/add")
    public R addUser(@RequestBody Register register, HttpServletRequest request) {
        log.info(register);
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute(register.getEmail());
        if (code.equals(register.getCode())) {
            User user = new User();
            user.setUsername(register.getUsername());
            user.setPassword(MD5Utils.md5(register.getPassword()));
            user.setEmail(register.getEmail());
            Boolean b = userService.register(user);
            if (b) {
                Role role = new Role();
                role.setUid(userService.selectUserByUsername(user.getUsername()).getId());
                role.setMenuid(200);
                role.setType("user");
                if (roleService.save(role)) {
                    return R.ok("注册成功");
                }
            }
            return R.error(400, "注册失败");
        }
        return R.error(400, "邮箱验证失败");
    }

    @PostMapping("/edit")
    public R editUser(@RequestBody User user) {
        log.info("修改用户数据 {}", user);
        if (user.getPassword() != null) {
            user.setPassword(MD5Utils.md5(user.getPassword()));
        }
        if (userService.updateUser(user)) {
            return R.ok("修改用户信息成功");
        }
        return R.error(400, "修改用户信息失败");
    }

    @DeleteMapping("/{id}")
    public R deleteUser(@PathVariable Integer id) {
        log.info("删除 id 为 {} 的用户", id);
        Role roleByUid = roleService.getRoleByUid(id);
        if (roleService.removeById(roleByUid)) {
            if (userService.deleteUser(id)) {
                return R.ok("删除用户成功");
            }
        }
        return R.error(400, "删除用户失败");
    }

    @PostMapping("/role")
    public R updateRole(@RequestBody User user) {
        log.info("参数===>{}", user);
        Role role = roleService.getRoleByUid(user.getId());
        if (user.getRole().equals("普通用户")) {
            role.setType("user");
            role.setMenuid(200);
        } else {
            role.setType("manage");
            role.setMenuid(100);
        }
        if (roleService.updateTypeAndMenuid(role) && userService.updateUser(user)) {
            return R.ok("修改权限成功");
        }
        return R.error(400, "修改权限失败");
    }

}
