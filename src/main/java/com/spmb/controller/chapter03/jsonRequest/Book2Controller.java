package com.spmb.controller.chapter03.jsonRequest;

import com.alibaba.fastjson.JSONObject;
import com.spmb.domain.chapter03.Book;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author: leiyulin
 * @date: 2018/6/7
 */
@Controller
@RequestMapping(value = "/json")
public class Book2Controller {
    private static final Log logger = LogFactory.getLog(Book2Controller.class);

    // @RequestBody根据json数据，转换成对应的Object
    @RequestMapping(value = "/testRequestBody2")
    public void setJson(@RequestBody Book book,
                        HttpServletResponse response) throws IOException {
        //使用JSONObject将book对象转换成json输出
        logger.info(JSONObject.toJSONString(book));

        book.setAuthor("肖文吉");
        response.setContentType("text/html;charset=UTF-8");
        logger.info(response);
        // 将book对象转换成json写出到客户端
        response.getWriter().println(JSONObject.toJSONString(book));
    }
}
