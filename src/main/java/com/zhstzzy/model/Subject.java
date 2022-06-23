package com.zhstzzy.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @TableName subject
 */
@TableName(value ="subject")
@Data
@RequiredArgsConstructor
public class Subject implements Serializable {
    /**
     * 课程id
     */
    @TableId(value = "subId", type = IdType.AUTO)
    private Integer subId;

    /**
     * 课程名称
     */
    @TableField(value = "subname")
    private String subname;

    /**
     * 课程价格
     */
    @TableField(value = "sellingPrice")
    private Double sellingPrice;

    /**
     * 课程详情
     */
    @TableField(value = "detail")
    private String detail;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}