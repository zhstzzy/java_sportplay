package com.zhstzzy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhstzzy.model.Role;
import com.zhstzzy.service.RoleService;
import com.zhstzzy.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author 35076
* @description 针对表【user_role】的数据库操作Service实现
* @createDate 2022-06-17 08:29:30
*/
@Service
@Transactional
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role getRoleByUid(Integer uid) {
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",uid);
        return roleMapper.selectOne(wrapper);
    }

    @Override
    public Boolean updateTypeAndMenuid(Role role) {
        return roleMapper.updateTypeAndMenuid(role) > 0;
    }
}




