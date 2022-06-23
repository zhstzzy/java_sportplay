package com.zhstzzy.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhstzzy.entity.UserAndSubject;
import com.zhstzzy.model.UserSubject;
import com.zhstzzy.service.UserSubjectService;
import com.zhstzzy.mapper.UserSubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 35076
* @description 针对表【user_subject】的数据库操作Service实现
* @createDate 2022-06-21 09:13:46
*/
@Service
public class UserSubjectServiceImpl extends ServiceImpl<UserSubjectMapper, UserSubject>
    implements UserSubjectService{

    @Autowired
    private UserSubjectMapper userSubjectMapper;

    @Override
    public IPage<UserAndSubject> selectUserSubject(IPage<?> page, Integer id) {
        return userSubjectMapper.selectByUid(page, id);
    }
}




