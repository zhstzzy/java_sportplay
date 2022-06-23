package com.zhstzzy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhstzzy.entity.UserAndSubject;
import com.zhstzzy.model.UserSubject;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 35076
* @description 针对表【user_subject】的数据库操作Service
* @createDate 2022-06-21 09:13:46
*/
public interface UserSubjectService extends IService<UserSubject> {

    IPage<UserAndSubject> selectUserSubject(IPage<?> page,Integer id);

}
