package com.zhstzzy.service;

import com.zhstzzy.model.Role;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 35076
* @description 针对表【user_role】的数据库操作Service
* @createDate 2022-06-17 08:29:30
*/
public interface RoleService extends IService<Role> {

    Role getRoleByUid(Integer uid);

    Boolean updateTypeAndMenuid(Role role);

}
