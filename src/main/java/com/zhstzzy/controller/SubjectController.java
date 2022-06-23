package com.zhstzzy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhstzzy.entity.R;
import com.zhstzzy.model.Goods;
import com.zhstzzy.model.Subject;
import com.zhstzzy.service.SubjectService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @Author : zhstzzy
 * @create 2022/6/16 8:29
 */
@RestController
@RequestMapping("/subject")
@Log4j2
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping()
    public R getAll() {
        List<Subject> list = subjectService.list();
        if (list != null) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("subjectList", list);
            return R.ok(map, "查询全部课程成功！");
        }
        return R.error(400,"课程为空");
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R getSubject(@PathVariable Integer currentPage, @PathVariable Integer pageSize, String goodsName) {
        log.info("分页查询课程");
        IPage<Subject> page = subjectService.getSubject(currentPage, pageSize, goodsName);
        if (currentPage > page.getPages()) {
            page = subjectService.getSubject((int) page.getPages(), pageSize, goodsName);
        }
        return R.ok(page, "查询课程成功！");
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {
        Subject subject = subjectService.selectById(id);
        if (subject == null) return R.error(400, "课程不存在");
        return R.ok(subject, "查询成功！");
    }

    @PutMapping
    public R addSubject(@RequestBody Subject subject) {
        log.info("插入课程数据 {}", subject);
        if (subjectService.addSubject(subject)) {
            return R.ok("插入课程成功");
        }
        return R.error(400, "插入课程失败");
    }

    @PostMapping
    public R updateSubject(@RequestBody Subject subject) {
        log.info("更新课程信息 {} ", subject);
        if (subjectService.updateSubject(subject)) {
            return R.ok("修改课程成功");
        }
        return R.error(400, "修改课程失败");
    }

    @DeleteMapping("/{id}")
    public R deleteGoods(@PathVariable Integer id) {
        log.info("删除 id 为 {} 的课程", id);
        if (subjectService.deleteSubject(id)) {
            return R.ok("删除课程成功");
        }
        return R.error(400, "删除课程失败");
    }

}
