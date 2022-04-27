package com.zhstzzy;

import com.zhstzzy.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavasportplayApplicationTests {

    @Autowired
    private UserDao dao;

    @Test
    void contextLoads() {
        System.out.println(dao.findUserByUsernameAndPassword("admin", "123456"));
    }

}
