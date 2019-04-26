package com.lovo.springboot.contorller;

import com.lovo.springboot.bean.PowerEntity;
import com.lovo.springboot.service.IPowerService;
import com.lovo.springboot.service.IRolePowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RolePowerController {

    @Autowired
    private IPowerService powerService;

    @Autowired
    private IRolePowerService rolePowerService;
    //跳转到权限-角色维护页面
    //他通过角色id得到相应的拥有该角色的权限
    // 和没有该角色的权限
    @RequestMapping("goToRolePower")
    public ModelAndView goToRolePower(String rname, String rid){
        ModelAndView mv = new ModelAndView("rolePower");

        //  角色拥有的权限
        List<PowerEntity> powerList = powerService.getPowerListByRoleId(rid);
        // 角色不拥有的权限
        List<PowerEntity> noPowerList = powerService.getPowerListNoByRoleId(powerList);

        mv.addObject("powerList", powerList);
        mv.addObject("noPowerList", noPowerList);

        //将角色名和角色id传回做相应处理
        mv.addObject("rname", rname);
        mv.addObject("rid", rid);

        return mv ;
    }

    @RequestMapping("/updateRolePowers")
    public ModelAndView updateRolePower(String rname,String rid,String addName,String delName){
        ModelAndView mv = new ModelAndView("rolePower");
        //添加关联关系
        rolePowerService.addRolePower(addName, rid);
        //删除关联关系
        rolePowerService.delRolePower(delName, rid);

        mv.addObject("rname", rname);
        mv.addObject("rid", rid);

        List<PowerEntity> powerList = powerService.getPowerListByRoleId(rid);
        //根据角色ID查询出不拥有的用户
        List<PowerEntity> noPowerList = powerService.getPowerListNoByRoleId(powerList);
        //把拥有的用户和不拥有的用户放入到模型
        mv.addObject("powerList", powerList);
        mv.addObject("noPowerList", noPowerList);

        return mv;
    }
}
