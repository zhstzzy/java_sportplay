package com.zhstzzy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhstzzy.model.Subject;
import com.zhstzzy.model.UserSubject;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author : zhstzzy
 * @create 2022/6/21 10:36
 */
@Data
@ToString(callSuper = true)
@RequiredArgsConstructor
public class UserAndSubject extends Subject {

    private Integer id;

    private Date startTime;

    private Date endTime;

}
