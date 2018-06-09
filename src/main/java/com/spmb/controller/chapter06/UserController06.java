package com.spmb.controller.chapter06;

import com.spmb.domain.chapter06.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * @Description:
 * @Author: leiyulin
 * @date: 2018/6/7
 */
@Controller
@RequestMapping(value = "/chapter06")
public class UserController06 {
    private static final Log logger = LogFactory.getLog(UserController06.class);

//    @RequestMapping(value = "/{formName}")
//    public String loginForm(@PathVariable String formName){
//        return formName;
//    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerForm() {
        logger.info("register Get 方法调用...");
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute User user, Model model){
        logger.info(user);
        model.addAttribute("user", user);
        return "success3";
    }

    @InitBinder
    //注册自定义编辑器，@InitBinder注解会在控制器初始化时注册属性编辑器。
    //WebDataBinder对象用于处理请求消息和处理方式的绑定工作。
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class, new DateEditor());
    }
}
