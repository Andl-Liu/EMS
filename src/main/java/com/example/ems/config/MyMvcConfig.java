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
//       // registry.addViewController("/*").setViewName("loginpage.html");
//        registry.addViewController("/index.html").setViewName("loginpage.html");
//      //  registry.addViewController("/loginpage.html").setViewName("loginpage.html");
//       // registry.addViewController("/pricelist.html").setViewName("loginpage.html");
//    }
//
//    //自定义的国际化组件
//    @Bean
//    public LocaleResolver localeResolver(){
//        return new MyLocaleResolver();
//    }
//
////    @Override
////    public void addInterceptors(InterceptorRegistry registry){
////        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
////                .excludePathPatterns("/index.html","/css/*","/js/*","/img/*","/pricelist.html","msgsearch.html","/purtabsearch.html","/wirttd.html","/alttd.html");
////    }
////    @Bean
////    public SessionInterceptor getSessionInterceptor() {
////        return new SessionInterceptor();
////    }
////
////    @Override
////    public void addInterceptors(InterceptorRegistry registry) {
////        /*调用我们创建的SessionInterceptor。
////         * addPathPatterns("/api/**)的意思是这个链接下的都要进入到SessionInterceptor里面去执行
////         * excludePathPatterns("/login")的意思是login的url可以不用进入到SessionInterceptor中，直接
////         * 放过执行。
////         *
////         * 注意：如果像注释那样写是不可以的。这样等于是创建了多个Interceptor。而不是只有一个Interceptor
////         * 所以这里有个大坑，搞了很久才发现问题。
////         *
////         * */
////        SessionInterceptor sessionInterceptor=new SessionInterceptor();
////        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**")
////                .excludePathPatterns("/login","/verify");
//////        registry.addInterceptor(sessionInterceptor).excludePathPatterns("/login");
//////        registry.addInterceptor(sessionInterceptor).excludePathPatterns("/verify");
////        super.addInterceptors(registry);
////    }
//}
