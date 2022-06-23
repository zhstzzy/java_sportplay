package com.zhstzzy.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @TableName user_subject
 */
@TableName(value ="user_subject")
@Data
public class UserSubject implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 开始时间
     */
    @TableField(value = "startTime")
    private Date startTime;

    /**
     * 结束时间
     */
    @TableField(value = "endTime")
    private Date endTime;

    /**
     * 课程id
     */
    @TableField(value = "subId")
    private Integer subId;

    /**
     * 用户id
     */
    @TableField(value = "uid")
    private Integer uid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}