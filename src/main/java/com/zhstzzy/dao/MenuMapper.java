package com.zhstzzy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhstzzy.model.MainMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author : zhstzzy
 * @create 2022/5/19 16:01
 */
@Mapper
public interface MenuMapper extends BaseMapper<MainMenu> {

//    @Select("select m.*, s.id sid,s.title stitle,s.path spath from mainmenu m,submenu s where m.id = s.mid;")
    List<MainMenu> getMenus();

}
