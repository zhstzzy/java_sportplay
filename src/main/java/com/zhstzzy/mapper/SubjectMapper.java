package com.zhstzzy.mapper;

import com.zhstzzy.model.Subject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 35076
* @description 针对表【subject】的数据库操作Mapper
* @createDate 2022-06-16 08:16:07
* @Entity com.zhstzzy.model.Subject
*/
@Mapper
public interface SubjectMapper extends BaseMapper<Subject> {

}




