package com.example.config;
//扩展SpringMVC

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

//会经过doDispatch这个函数（class DispatcherServlet）
@Configuration
public class MyConfig implements WebMvcConfigurer {

    //public interface ViewResolver 实现了视图解析器接口的类，我们就可以把它看作视图解析器
    @Bean
    public ViewResolver myViewResolver() {
        return new MyViewResolver();
    }

    ;

    public static class MyViewResolver implements ViewResolver {
        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }

//    @Bean
//    public HandlerInterceptor loginHandlerInterceptor(){
//        return new LoginHandlerInterceptor();
//    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(1800)
//                .allowedOrigins("*");
                .allowedOrigins("http://43.143.211.83:8081/", "http://43.143.211.83:8082/","http://localhost:8081/")
                .allowCredentials(true); //允许cookie跨域
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/index.html","/","/user/login","/css/*","js/*","/img/*");
//    }

}

