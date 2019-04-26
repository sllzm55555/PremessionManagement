package com.lovo.springboot.config;

import com.lovo.springboot.bean.UserBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//Spring启动的时候就运行它，相当于spring里面的上下文
@Configuration
public class BaseConfig {

    public BaseConfig(){
        System.out.println("执行了构造方法!");
    }
    //相当于xml里面的bean标签
    @Bean(value = "userBean") //可以让测试类直接加载到,交给spring来管理
    public UserBean getUserBean(){
        UserBean userBean = new UserBean();
        userBean.setId("12345");
        userBean.setUserName("wangwu");
        return userBean;
    }
}
