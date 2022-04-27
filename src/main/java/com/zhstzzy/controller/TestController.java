package com.zhstzzy.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

/**
 * @Author : zhstzzy
 * @create 2022/4/24 16:18
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @PostMapping
    @CrossOrigin
    public String test(){
        String test = "This is TestController";
        System.out.println(test);
        return test;
    }

}
