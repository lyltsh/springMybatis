package com.spmb.controller.chapter03.jsonRequest;

import com.spmb.domain.chapter03.Book;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: leiyulin
 * @date: 2018/6/7
 */
@Controller
@RequestMapping(value = "/json")
public class Book3Controller {
    private static final Log logger = LogFactory.getLog(Book3Controller.class);

    // @RequestBody根据json数据，转换成对应的Object
    @RequestMapping(value = "/testRequestBody3")
    @ResponseBody
    //@ResponseBody将集合数据转换为json格式并将其返回给客户端
    public Object setJson() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1,"spring","lll"));
        bookList.add(new Book(2,"mvc","yyy"));
        return bookList;
    }
}
