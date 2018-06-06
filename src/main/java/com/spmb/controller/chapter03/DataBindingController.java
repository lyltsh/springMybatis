package com.spmb.controller.chapter03;

import com.spmb.domain.chapter03.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @Description:
 * @Author: leiyulin
 * @date: 2018/6/6
 */
@Controller
//将Model中的属性名为user的属性放入HTTPSession对象中
@SessionAttributes(value = "user")
public class DataBindingController {

    private static final Log logger = LogFactory.getLog(DataBindingController.class);

    @RequestMapping(value = "/{formName}")
    public String loginForm(@PathVariable String formName){
        //跳转动态页面
        return formName;
    }

    @RequestMapping(value = "/login")
    public String login(
            @RequestParam("loginname") String loginname,
            @RequestParam("password") String password,
            Model model
    ){
        User user = new User(loginname, password, "admin");
        model.addAttribute("user", user);
        return "welcome";
    }
}
