package com.zhstzzy.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhstzzy.entity.UserAndSubject;
import com.zhstzzy.model.UserSubject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 35076
* @description 针对表【user_subject】的数据库操作Mapper
* @createDate 2022-06-21 09:13:46
* @Entity com.zhstzzy.model.UserSubject
*/
@Mapper
public interface UserSubjectMapper extends BaseMapper<UserSubject> {


    IPage<UserAndSubject> selectByUid(IPage<?> page, Integer id);

}




