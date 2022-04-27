package com.zhstzzy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author : zhstzzy
 * @create 2022/4/23 15:48
 */

//全局配置类--配置跨域请求
@Configuration
public class CorsConfig  implements WebMvcConfigurer {

    /**
     * 重写 addCorsMappings 方法，实现跨域操作
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                //允许跨域的域名，可以用*表示允许任何域名使用
//                allowedOrigins(""). // 当 allowCredentials 为 true 时，不能为 "*"
                .allowedOriginPatterns("http://localhost:8080").
                //允许任何方法（post、get等）
                allowedMethods("*").
                //允许任何请求头
                allowedHeaders("*").
                //带上cookie信息
                allowCredentials(true).
                //maxAge(3600)表明在3600秒内，不需要再发送预检验请求，可以缓存该结果
                //设置允许时间
                exposedHeaders(HttpHeaders.SET_COOKIE).maxAge(3600L);
    }
}
