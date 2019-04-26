package com.lovo.springboot.contorller;

import com.lovo.springboot.bean.PowerEntity;
import com.lovo.springboot.service.IPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TurnPageController {
    /**
     * 不让直接访问html，因此需要人为的去作页面跳转
     */
    @RequestMapping("goToLoginPage")
    public String goToLoginPage() {
        return "login";
    }

    @RequestMapping("goToMainPage")
    public String goToMainPage() {
        return "main";
    }

    @Autowired
    private IPowerService powerService;
    @RequestMapping("goToPowerPage")
    public ModelAndView goToPowerPage() {
        ModelAndView mv = new ModelAndView("power");

        List<PowerEntity> powerList = powerService.getAllPower();
        mv.addObject("powerList", powerList);

        return mv;
    }


}
