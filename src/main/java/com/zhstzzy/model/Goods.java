package com.zhstzzy.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @TableName goods
 */
@TableName(value = "goods")
@Data
@RequiredArgsConstructor
public class Goods implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 商品id
     */
    @TableId(value = "goodsId", type = IdType.AUTO)
    private Integer goodsId;

    /**
     * 商品名称
     */
    @TableField(value = "goodsName")
    private String goodsName;

    /**
     * 单位
     */
    @TableField(value = "unit")
    private String unit;

    /**
     * 单价
     */
    @TableField(value = "unitPrice")
    private Double unitPrice;

    /**
     * 卖价
     */
    @TableField(value = "sellPrice")
    private Double sellPrice;

    /**
     * 库存
     */
    @TableField(value = "inventory")
    private Integer inventory;


}