package com.lovo.springboot.util;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//相当于是springMVC.xml里面的；拦截器配置
@Component
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    //拦截器放行静态页面
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //表示拦截所有
        registry.addInterceptor(new PowerInterceptor()).addPathPatterns("/**");
    }
    //因为配置了拦截器，所以springMVC的dispatcherServlet就会启动，原来静态资源加载就会出问题了
    //放行静态的文件
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}
