package com.zhstzzy.mapper;

import com.zhstzzy.model.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 35076
* @description 针对表【user_role】的数据库操作Mapper
* @createDate 2022-06-17 08:29:30
* @Entity com.zhstzzy.model.Role
*/
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    Integer updateTypeAndMenuid(Role role);

}




