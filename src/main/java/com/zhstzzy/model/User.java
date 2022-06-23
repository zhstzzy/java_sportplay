package com.zhstzzy.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("users")
public class User implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;
    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;
    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;
    /**
     * 角色
     */
    @TableField(value = "role")
    private String role;
    /**
     * 状态
     */
    @TableField(value = "state")
    private Boolean state;

    public User(String username, String password, String email, String role, Boolean state) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.state = state;
    }
}
