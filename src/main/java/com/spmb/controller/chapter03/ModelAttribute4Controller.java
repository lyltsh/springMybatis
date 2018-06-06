package com.spmb.controller.chapter03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: leiyulin
 * @date: 2018/6/6
 */
@Controller
@RequestMapping(value = "/model")
public class ModelAttribute4Controller {

    /**
     * 此时login4方法的返回值并不是一个视图名称，而是model属性的值，视图名称是@RequestMapping(value = "/login4")的value值
     * model的属性名称是由@ModelAttribute(value = "username")指定，相当于在request里面封装了username(key)=admin(value)
     *
     * @return
     */
    @RequestMapping(value = "/login4")
    @ModelAttribute(value = "username")
    public String login4() {
        return "admin";
    }
}
