package com.zhstzzy.controller;

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
        String test = "";
        System.out.println(test);
        return test;
    }

}
