package cn.tangtj.clouddisk.annotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 此类可在spring-boot项目中用@Configuration实现，省去xml配置
// @Configuration
public class MyConfig implements WebMvcConfigurer {
//    public void addInterceptors(InterceptorRegistry registry){
//        System.out.println("拦截全部");
//        // 使拦截器生效 1.此处参数是我们自定义的拦截器名( SourceAccessInterceptor )
//        // 2.添加拦截规则(/**)拦截全部
//        registry.addInterceptor(new SourceAccessInterceptor()).addPathPatterns("/**");
//        WebMvcConfigurer.super.addInterceptors(registry);
//    }
}
