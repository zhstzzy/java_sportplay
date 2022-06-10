package com.zhstzzy;

import com.zhstzzy.dao.UserMapper;
import com.zhstzzy.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavasportplayApplicationTests {

    @Autowired
    private UserMapper dao;

    @Autowired
    private UserService service;

    @Test
    void contextLoads() {
    }

}
