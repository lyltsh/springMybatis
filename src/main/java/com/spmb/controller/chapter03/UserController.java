package com.spmb.controller.chapter03;

import com.spmb.domain.chapter03.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: leiyulin
 * @date: 2018/6/6
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static List<User> userList;

    public UserController() {
        super();
        userList = new ArrayList<User>();
    }

    private static final Log logger = LogFactory.getLog(UserController.class);

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerForm() {
        logger.info("register Get 方法调用...");
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(
            @RequestParam("loginname") String loginname,
            @RequestParam("password") String password,
            @RequestParam("username") String username
    ) {
        logger.info("register Post 方法调用...");
        User user = new User(loginname, password, username);
        //模拟数据库存储
        userList.add(user);
        return "loginForm";
    }

    @RequestMapping(value = "/login")
    public String login(
            @RequestParam("loginname") String loginname,
            @RequestParam("password") String password,
            Model model
    ) {
        logger.info("登录名：" + loginname + "，登录密码：" + password);
        for (User user : userList) {
            if (user.getLoginname().equals(loginname)
                    && user.getPassword().equals(password)) {
                model.addAttribute("user", user);
                return "welcome";
            }
        }
        return "loginForm";
    }

    @RequestMapping(value = "/register/{id}")
    public String pathVariable(@PathVariable String id) {
        logger.info("PathVariable..." + id);
        return "registerForm";
    }

    @RequestMapping(value = "/requestHeader")
    public String requestHeader(
            @RequestHeader("User-Agent") String userAgent,
            @RequestHeader(value = "Accept") String[] accepts
    ) {
        logger.info("requestHeader...");
        logger.info(userAgent);
        for (int i = 0; i < accepts.length; i++) {
            logger.info(accepts[i]);
        }
        return "registerForm";
    }

    @RequestMapping(value = "/cookies")
    public String cookies(
            @CookieValue(value = "JSESSIONID", defaultValue = "") String jsessionId
    ) {
        logger.info("cookies..." + jsessionId);

        return "registerForm";
    }
}
