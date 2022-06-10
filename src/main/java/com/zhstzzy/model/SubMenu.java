package com.zhstzzy.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

/**
 * @Author : zhstzzy
 * @create 2022/5/19 15:56
 * 分支导航
 */
@Data
@RequiredArgsConstructor
@TableName("submenu")
public class SubMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String title;
    private String path;
    private String icon;

    public SubMenu(String title, String path, String icon) {
        this.title = title;
        this.path = path;
        this.icon = icon;
    }
}
