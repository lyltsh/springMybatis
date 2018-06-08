package com.spmb.controller.chapter03.jsonRequest;

import com.spmb.domain.chapter03.Book;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
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
public class BookController {
    private static final Log logger = LogFactory.getLog(BookController.class);

    // @RequestBody根据json数据，转换成对应的Object
    @RequestMapping(value = "/testRequestBody")
    public void setJson(@RequestBody Book book,
                        HttpServletResponse response) throws IOException {
        // ObjectMapper类是Jackson库的主要类。它提供一些功能将Java对象转换成对应的JSON格式的数据
        logger.info(book);
        ObjectMapper mapper = new ObjectMapper();
        // 将book对象转换成json输出
        logger.info(mapper.writeValueAsString(book));
        book.setAuthor("肖文吉");
        response.setContentType("text/html;charset=UTF-8");
        logger.info(response);
        // 将book对象转换成json写出到客户端
        response.getWriter().println(mapper.writeValueAsString(book));
    }
}
