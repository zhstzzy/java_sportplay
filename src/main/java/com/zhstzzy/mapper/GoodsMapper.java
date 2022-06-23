package com.zhstzzy.mapper;

import com.zhstzzy.model.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 35076
* @description 针对表【goods】的数据库操作Mapper
* @createDate 2022-06-14 19:52:18
* @Entity com.zhstzzy.model.Goods
*/
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

}




