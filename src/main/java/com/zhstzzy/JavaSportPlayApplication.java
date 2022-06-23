package com.zhstzzy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author : zhstzzy
 * @create 2022/4/25 20:40
 */
@SpringBootApplication
@MapperScan("com.zhstzzy.mapper")
public class JavaSportPlayApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaSportPlayApplication.class, args);
    }

}
