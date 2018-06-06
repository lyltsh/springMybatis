package com.spmb.controller.chapter03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description:
 * @Author: leiyulin
 * @date: 2018/6/6
 */
@Controller
@RequestMapping(value = "/model")
public class ModelAttribute3Controller {
    //model属性名称和值由model.addAttribute()实现，前提是在方法中加入一个model类型的参数
    @ModelAttribute
    public String userModel3(
            @RequestParam(value = "loginname", required = false) String loginname,
            @RequestParam(value = "password", required = false) String password,
            Model model
    ){
        model.addAttribute("loginname", loginname);
        model.addAttribute("password", password);
        return loginname;
    }

    @RequestMapping(value = "/login3")
    public String login3(){
        return "result3";
    }
}
