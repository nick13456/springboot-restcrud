package com.springboot.restfulcrud.config;

import com.springboot.restfulcrud.interceptor.MyLoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    /**
     *
     * 转发请求
     *@param registry
     *
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       registry.addViewController("/login").setViewName("login");
    }

    @Bean
    public WebMvcConfigurerAdapter webadapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            /**
             * 配置拦截器，利用配置好的拦截器来选择哪些请求需要拦截，哪些请求不拦截
             * @param registry
             */
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new MyLoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/login","/userlogin");

            }
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }


}
