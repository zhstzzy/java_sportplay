package com.zhstzzy.mapper;

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
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from easyuser where username = #{username} and password = #{password} and state = 1")
    User findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

//    List<User> getAllUser(@Param("username") String username, @Param("pageStart") int pageStart, @Param("pageSize")int pageSize);

    int insertUser(User user);

}
