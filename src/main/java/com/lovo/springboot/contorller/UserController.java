package com.lovo.springboot.contorller;

import com.lovo.springboot.bean.UserBean;
import com.lovo.springboot.bean.UserEntity;

import com.lovo.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    IUserService userService;

    @RequestMapping("saveUser")
    public ModelAndView getUserEntity(UserEntity user) {
        ModelAndView mv = new ModelAndView();
        userService.saveUserEntity(user);
        mv.addObject("user", user);

        List<UserEntity> userList = userService.findAllUser();
        mv.addObject("userList", userList);
        mv.setViewName("show");
        return mv;
    }
    /**
     * 不让直接访问html，因此需要人为的去作页面跳转
     */
    @RequestMapping("goToTestPage")
    public String goToTestPage() {
        return "test";
    }


    @RequestMapping("getUserBean")
    public UserBean getUserBean() {
        UserBean userBean = new UserBean();
        userBean.setId("123");
        userBean.setUserName("wangwu");
        return userBean;
    }



    @RequestMapping("saveUserEntity")
    public UserEntity saveUserEntity() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUid("1233h");
        userEntity.setUname("zhangsan");
        userEntity.setUpasss("0607");
        userService.saveUserEntity(userEntity);
        return userEntity;
    }

}
