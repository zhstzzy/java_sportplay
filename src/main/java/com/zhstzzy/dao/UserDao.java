package com.zhstzzy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhstzzy.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author : zhstzzy
 * @create 2022/4/27 19:24
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

    @Select("select * from easyuser where username = #{username} and password = #{password} and state = 1")
    User findUserByUsernameAndPassword(@Param("username") String username,@Param("password") String password);

}