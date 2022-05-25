package com.zhstzzy.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

/**
 * @Author : zhstzzy
 * @create 2022/4/27 18:44
 * @TableName easyuser
 */
@Data
@RequiredArgsConstructor
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 角色
     */
    private String role;
    /**
     * 状态
     */
    private Boolean state;

    public Users(String username, String password, String email, String role, Boolean state) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.state = state;
    }
}
