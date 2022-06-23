package com.zhstzzy.entity;

import com.zhstzzy.model.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * @Author : zhstzzy
 * @create 2022/6/13 10:00
 */
@Data
@ToString(callSuper = true)
@RequiredArgsConstructor
public class Register extends User {
    private String checkPassword;
    private String code;
}
