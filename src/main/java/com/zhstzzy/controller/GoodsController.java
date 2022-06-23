package com.zhstzzy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhstzzy.entity.R;
import com.zhstzzy.entity.RHttpStatusEnum;
import com.zhstzzy.model.Goods;
import com.zhstzzy.model.User;
import com.zhstzzy.service.GoodsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author : zhstzzy
 * @create 2022/6/14 20:06
 */
@RestController
@RequestMapping("/goods")
@Log4j2
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/{currentPage}/{pageSize}")
    public R getGoods(@PathVariable Integer currentPage, @PathVariable Integer pageSize, String goodsName){
        log.info("分页查询商品");
        IPage<Goods> page = goodsService.getGoods(currentPage, pageSize, goodsName);
        if (currentPage > page.getPages()) {
            page = goodsService.getGoods((int) page.getPages(), pageSize, goodsName);
        }
        return R.ok(page, "查询商品成功！");
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {
        Goods goods = goodsService.selectById(id);
        if (goods == null) return R.error(400, "商品不存在");
        return R.ok(goods, "查询成功！");
    }

    @PutMapping
    public R addGoods(@RequestBody Goods goods){
        log.info("插入商品数据 {}",goods);
        if (goodsService.addGood(goods)) {
            return R.ok("插入商品成功");
        }
        return R.error(400,"插入商品失败");
    }

    @PostMapping
    public R updateGoods(@RequestBody Goods goods){
        log.info("更新商品信息 {} ",goods);
        if (goodsService.updateGood(goods)){
            return R.ok("修改商品成功");
        }
        return R.error(400,"修改商品失败");
    }

    @DeleteMapping("/{id}")
    public R deleteGoods(@PathVariable Integer id){
        log.info("删除 id 为 {} 的商品",id);
        if (goodsService.deleteGood(id)){
            return R.ok("删除商品成功");
        }
        return R.error(400,"删除商品失败");
    }

}
