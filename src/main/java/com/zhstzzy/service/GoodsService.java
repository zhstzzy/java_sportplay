package com.zhstzzy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhstzzy.model.Goods;
import com.baomidou.mybatisplus.extension.service.IService;


/**
* @author 35076
* @description 针对表【goods】的数据库操作Service
* @createDate 2022-06-14 19:52:18
*/
public interface GoodsService extends IService<Goods> {

    IPage<Goods> getGoods(Integer currentPage, Integer pageSize, String goodName);

    Goods selectById(Integer id);

    Boolean addGood(Goods goods);

    Boolean updateGood(Goods goods);

    Boolean deleteGood(Integer id);



}
