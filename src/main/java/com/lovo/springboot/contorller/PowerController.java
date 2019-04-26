package com.lovo.springboot.contorller;

import com.lovo.springboot.bean.PowerEntity;
import com.lovo.springboot.service.IPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PowerController {
    @Autowired
    private IPowerService powerService;

    @RequestMapping("savePowerEntity")
    public ModelAndView savePowerEntity(String powerName, String resourceName) {
        ModelAndView mv = new ModelAndView("power");
        PowerEntity powerEntity = new PowerEntity();
        //设置权限名
        powerEntity.setPname(powerName);
        powerEntity.setPuri(resourceName);
        //添加权限
        powerService.savePowerEntity(powerEntity);

        mv.addObject("powerEntity", powerEntity);
        List<PowerEntity> powerList = powerService.getAllPower();
        mv.addObject("powerList", powerList);

        return mv;
    }
}
