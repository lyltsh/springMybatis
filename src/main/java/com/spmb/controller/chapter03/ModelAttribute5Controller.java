package com.spmb.controller.chapter03;

import com.spmb.domain.chapter03.User;
import org.springframework.stereotype.Controller;
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
public class ModelAttribute5Controller {
    // model属性名称就是value值即”user”，model属性对象就是方法的返回值
    @ModelAttribute(value = "user")
    public User userModel5(
            @RequestParam(value = "loginname", required = false) String loginname,
            @RequestParam(value = "password", required = false) String password
    ) {
        User user = new User();
        user.setLoginname(loginname);
        user.setPassword(password);
        return user;
    }

    // @ModelAttribute("user") User user注释方法参数，参数user的值来源于userModel5()方法中的model属性。
    @RequestMapping(value = "/login5")
    public String login5(@ModelAttribute("user") User user) {
        user.setUsername("管理员");
        return "result5";
    }
}
