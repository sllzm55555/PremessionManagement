package com.lovo.springboot.contorller;

import com.lovo.springboot.bean.RoleEntity;
import com.lovo.springboot.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class RoleController {
    @Autowired
    private IRoleService roleService;

    //跳转到role页面
    @RequestMapping("goToRolePage")
    public ModelAndView goToRolePage() {
        ModelAndView mv=new ModelAndView("role");
        List<RoleEntity> listRole =	roleService.findAllRole();
        //把结果放入到模型
        mv.addObject("roleList", listRole);
        return mv;
    }


    @RequestMapping("saveRoleEntity")
    private ModelAndView saveRoleEntity(String roleName,String roleDescribe) {
        ModelAndView mv = new ModelAndView("role");

        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setRname(roleName);
        roleEntity.setRoleDescribe(roleDescribe);

        roleService.saveRoleEntity(roleEntity);

        /*List<RoleEntity> listRole =	roleService.findAllRole();
        mv.addObject("roleList", listRole);*/
        //重定向到goToRolePage，展示所有角色
        RedirectView rv = new RedirectView("goToRolePage");
        mv.setView(rv);

        return mv;
    }
}
