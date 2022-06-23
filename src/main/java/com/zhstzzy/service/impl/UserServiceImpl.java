package com.zhstzzy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhstzzy.mapper.UserMapper;
import com.zhstzzy.entity.R;
import com.zhstzzy.model.User;
import com.zhstzzy.service.UserService;
import com.zhstzzy.utils.EmailService;
import com.zhstzzy.utils.JwtUtil;
import com.zhstzzy.utils.MD5Utils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.Map;

import static com.zhstzzy.entity.RHttpStatusEnum.HTTP_NOT_FOUND;

/**
 * @Author : zhstzzy
 * @create 2022/4/27 19:43
 */
@Service("userService")
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EmailService emailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Override
    public R login(User user) {
        if (user != null) {
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            Map<String, Object> params = new HashMap<>();
            params.put("username", user.getUsername());
            params.put("password", MD5Utils.md5(user.getPassword()));
            wrapper.allEq(params, false);
            User loginUser = userMapper.selectOne(wrapper);
            HashMap<String, Object> map = new HashMap<>();
            if (loginUser != null) {
                String token = JwtUtil.createToken(loginUser.getId(), loginUser.getUsername(), loginUser.getRole());
                map.put("id", loginUser.getId());
                map.put("username", loginUser.getUsername());
                map.put("role", loginUser.getRole());
                map.put("token", token);
                return R.ok(1000,map, "登录成功!");
            }
        }
        return R.error(400, "用户名或密码错误!");
    }

    @Override
    public IPage<User> getUsers(Integer currentPage, Integer pageSize, String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (Strings.isNotEmpty(username)) {
            wrapper.like("username", username);
        }
        IPage<User> usersPage = new Page<>(currentPage, pageSize);
        userMapper.selectPage(usersPage, wrapper);
        return usersPage;
    }

    @Override
    public User selectUserById(Integer id) {
        if (id == null) return null;
        return userMapper.selectById(id);
    }

    @Override
    public User selectUserByUsername(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (Strings.isNotEmpty(username)) {
            wrapper.eq("username", username);
            return userMapper.selectOne(wrapper);
        }
        return null;
    }

    @Override
    public Boolean updateState(User user) {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        if (user != null) {
            wrapper.eq("id", user.getId());
            return userMapper.update(user, wrapper) > 0;
        }
        return false;
    }

    @Override
    public void sendMail(String text, String code, String to) {
        Context context = new Context();
        context.setVariable("text", text);
        context.setVariable("code", code);
        String emailContent = templateEngine.process("emailTemplate", context);
        emailService.sendHtmlMail(to, "验证码", emailContent);
    }

    @Override
    public Boolean register(User user) {
        return userMapper.insertUser(user) > 0;
    }

    @Override
    public Boolean updateUser(User user) {
        return userMapper.updateById(user) > 0;
    }

    @Override
    public Boolean deleteUser(Integer id) {
        return userMapper.deleteById(id) > 0;
    }


}
