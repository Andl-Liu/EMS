//package com.example.ems.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.HandlerExceptionResolver;
//import org.springframework.web.servlet.LocaleResolver;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.List;
//
//@Configuration
//public class MyMvcConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry){
//        registry.addViewController("/").setViewName("index");
//        registry.addViewController("/loginpage.html").setViewName("index");
//        registry.addViewController("/main.html").setViewName("dashboard");
//    }
//
//    //自定义的国际化组件
//    @Bean
//    public LocaleResolver localeResolver(){
//        return new MyLocaleResolver();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry){
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/loginpage.html","/user/login","/css/*","/js/*","/img/*","/addUser/*","/deleteUser/*","/queryUserList/*","/updateUser/*","/addUser2/*","/queryUserList/*","/deleteUser2/*","/updateUser2/*");
//    }
//}
