package com.swj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author 孙文举
 * @description
 * @create 2020-03-15 18:42
 */
//自定义mvc的配置,我们想要这个类来全面扩展springmvc的配置
//如果你想diy一些定制化的功能,只要写这个组件,然后将他交给springboot,springboot就会帮我们自动装配!
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    //国际化注入到springboot容器中
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
    //注册拦截器

    //这个是视图控制器,这里面同一写好了重定向的页面,这样就不用在写一个controller
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/tohome").setViewName("dashboard");//登录成功,跳转到首页
        registry.addViewController("/").setViewName("index");
    }

    //注册一个拦截器,添加拦截路径,过滤拦截路径
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/static/**", "/", "/loginCheck");
        //  /**的意思是所有文件夹及里面的子文件夹
        //  /* 是所有文件夹，不含子文件夹
    }
}