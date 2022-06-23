package com.zhstzzy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhstzzy.entity.R;
import com.zhstzzy.entity.UserAndSubject;
import com.zhstzzy.model.UserSubject;
import com.zhstzzy.service.UserSubjectService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Author : zhstzzy
 * @create 2022/6/21 9:15
 */
@RestController
@RequestMapping("/userSubject")
@Log4j2
public class UserSubjectController {

    @Autowired
    private UserSubjectService userSubjectService;

    @PutMapping
    public R addUserSubject(@RequestBody UserSubject userSubject){
        log.info("添加userSubject参数====>{}",userSubject);
        if (userSubjectService.save(userSubject)) {
            return R.ok("添加课程成功");
        }
        return R.error(400,"添加失败");
    }

    @GetMapping
    private R getAll(Page<UserAndSubject> page,@RequestParam("id") Integer id){
        log.info("查询用户所选课程");
        userSubjectService.selectUserSubject(page, id);
        if (page.getTotal() != 0){
            return R.ok(page,"查询用户所选课程成功");
        }
        return R.error(400,"查询数据为空");
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id){
        log.info("删除id为{}的所选课程",id);
        if (userSubjectService.removeById(id)){
            return R.ok("删除成功");
        }else {
            return R.error(400,"删除失败");
        }
    }
}
