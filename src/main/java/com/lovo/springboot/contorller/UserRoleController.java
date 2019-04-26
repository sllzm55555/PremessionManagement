package com.lovo.springboot.contorller;


import com.lovo.springboot.bean.RoleEntity;
import com.lovo.springboot.bean.UserEntity;
import com.lovo.springboot.service.IRoleService;
import com.lovo.springboot.service.IUserRoleService;
import com.lovo.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class UserRoleController {



    @Autowired
    private IUserService userService;

    @Autowired
    private IUserRoleService userRoleService;


    //跳转到用户-角色维护页面
    //他通过角色id得到相应的拥有该角色的用户
    // 和没有该角色的用户
    @RequestMapping("goToRoleUser")
    public ModelAndView goToRoleUser(String rname,String rid){
        ModelAndView mv = new ModelAndView("roleUser");

        //roleUserList  角色拥有的用户
        List<UserEntity> userList = userService.getUserListByRoleId(rid);
        mv.addObject("userList", userList);

        //roleUserNoList 角色不拥有的用户
        List<UserEntity> noUserRoleList = userService.getNOUserListByRoleId(userList);
        mv.addObject("noUserRoleList", noUserRoleList);

        //将角色id和角色名传回到页面
        mv.addObject("rname", rname);
        mv.addObject("rid", rid);
        return mv ;
    }

    @RequestMapping("updateRoleUsers")
    public ModelAndView updateRoleUser(String rname,String rid,String addName,String delName){
        ModelAndView mv = new ModelAndView("roleUser");
        //添加关联关系
        userRoleService.addUserList(addName, rid);
        //删除关联关系
        userRoleService.delUserList(delName, rid);

        mv.addObject("rname", rname);
        mv.addObject("rid", rid);

        List<UserEntity> userList=	userService.getUserListByRoleId(rid);
        //根据角色ID查询出不拥有的用户
        List<UserEntity> noUserRoleList=userService.getNOUserListByRoleId(userList);
        //把拥有的用户和不拥有的用户放入到模型
        mv.addObject("userList", userList);
        mv.addObject("noUserRoleList", noUserRoleList);

        return mv;
    }




}
