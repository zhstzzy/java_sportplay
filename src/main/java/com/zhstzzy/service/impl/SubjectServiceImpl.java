package com.zhstzzy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhstzzy.model.Subject;
import com.zhstzzy.service.SubjectService;
import com.zhstzzy.mapper.SubjectMapper;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author 35076
* @description 针对表【subject】的数据库操作Service实现
* @createDate 2022-06-16 08:16:07
*/
@Service
@Transactional
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject>
    implements SubjectService{

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public IPage<Subject> getSubject(Integer currentPage, Integer pageSize, String subname) {
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        if (Strings.isNotEmpty(subname)) {
            wrapper.like("subname",subname);
        }
        IPage<Subject> subjectPage = new Page<>(currentPage,pageSize);
        subjectMapper.selectPage(subjectPage,wrapper);
        return subjectPage;
    }

    @Override
    public Subject selectById(Integer id) {
        return subjectMapper.selectById(id);
    }

    @Override
    public Boolean addSubject(Subject subject) {
        return subjectMapper.insert(subject)>0;
    }

    @Override
    public Boolean updateSubject(Subject subject) {
        return subjectMapper.updateById(subject)>0;
    }

    @Override
    public Boolean deleteSubject(Integer id) {
        return subjectMapper.deleteById(id)>0;
    }
}




