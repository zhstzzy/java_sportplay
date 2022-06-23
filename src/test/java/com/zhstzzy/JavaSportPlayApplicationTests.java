package com.zhstzzy;

import com.zhstzzy.model.Goods;
import com.zhstzzy.utils.EmailService;
import com.zhstzzy.utils.MD5Utils;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@SpringBootTest
@Log4j2
class JavaSportPlayApplicationTests {

    @Autowired
    private EmailService emailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    void contextLoads() {

    }
    @Test
    public void sendTemplateMail() {
        log.info(MD5Utils.md5("888888"));
    }

}
