package com.zhstzzy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Author : zhstzzy
 * @create 2022/5/19 15:58
 * 主导航
 */
@Data
@RequiredArgsConstructor
public class MainMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String title;
    private String path;

    private String icon;
    private List<SubMenu> subList;

    public MainMenu(String title, String path, String icon, List<SubMenu> subList) {
        this.title = title;
        this.path = path;
        this.icon = icon;
        this.subList = subList;
    }
}
