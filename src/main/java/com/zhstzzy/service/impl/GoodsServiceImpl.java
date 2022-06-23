package com.zhstzzy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhstzzy.model.Goods;
import com.zhstzzy.model.User;
import com.zhstzzy.service.GoodsService;
import com.zhstzzy.mapper.GoodsMapper;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 35076
 * @description 针对表【goods】的数据库操作Service实现
 * @createDate 2022-06-14 19:52:18
 */
@Service
@Transactional
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public IPage<Goods> getGoods(Integer currentPage, Integer pageSize, String goodName) {
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        if (Strings.isNotEmpty(goodName)) {
            wrapper.like("goodsName", goodName);
        }
        IPage<Goods> goodsPage = new Page<>(currentPage, pageSize);
        goodsMapper.selectPage(goodsPage, wrapper);
        return goodsPage;
    }

    @Override
    public Goods selectById(Integer id) {
        return goodsMapper.selectById(id);
    }

    @Override
    public Boolean addGood(Goods goods) {
        return goodsMapper.insert(goods) > 0;
    }

    @Override
    public Boolean updateGood(Goods goods) {
        return goodsMapper.updateById(goods) > 0;
    }

    @Override
    public Boolean deleteGood(Integer id) {
        return goodsMapper.deleteById(id) > 0;
    }
}




