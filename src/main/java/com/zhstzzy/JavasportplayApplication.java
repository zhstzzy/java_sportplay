package com.zhstzzy;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author : zhstzzy
 * @create 2022/4/25 20:40
 */
@SpringBootApplication
@MapperScan("com.zhstzzy.dao")
public class JavasportplayApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavasportplayApplication.class, args);
    }

}
