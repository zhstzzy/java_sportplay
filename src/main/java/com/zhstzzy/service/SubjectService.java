package com.zhstzzy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhstzzy.model.Subject;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 35076
* @description 针对表【subject】的数据库操作Service
* @createDate 2022-06-16 08:16:07
*/
public interface SubjectService extends IService<Subject> {

    IPage<Subject> getSubject(Integer currentPage, Integer pageSize, String goodName);

    Subject selectById(Integer id);

    Boolean addSubject(Subject subject);

    Boolean updateSubject(Subject subject);

    Boolean deleteSubject(Integer id);

}
