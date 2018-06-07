package com.spmb.controller.chapter06;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * @Description:
 * @Author: leiyulin
 * @date: 2018/6/7
 */
public class DateBindingInitializer implements WebBindingInitializer {
    @Override
    public void initBinder(WebDataBinder webDataBinder, WebRequest webRequest) {
        //注册自定义编辑器
        webDataBinder.registerCustomEditor(Date.class, new DateEditor());
    }
}
