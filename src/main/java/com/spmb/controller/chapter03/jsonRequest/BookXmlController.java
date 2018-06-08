package com.spmb.controller.chapter03.jsonRequest;

import com.spmb.domain.chapter03.Book;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

/**
 * @Description:
 * @Author: leiyulin
 * @date: 2018/6/7
 */
public class BookXmlController {
    private static final Log logger = LogFactory.getLog(BookXmlController.class);

    // @RequestBody Book book会将传递的xml数据自动绑定到Book对象
    @RequestMapping(value = "/sendxml", method = RequestMethod.POST)
    public void sendxml(@RequestBody Book book) {
        logger.info(book);
        logger.info("接收XML数据成功");
    }

    // @ResponseBody 会将Book自动转成XML数据返回
    @RequestMapping(value = "/readxml", method = RequestMethod.POST)
    public @ResponseBody
    Book readXml() throws Exception {
        // 通过JAXBContext的newInstance方法，传递一个class就可以获得一个上下文
        JAXBContext context = JAXBContext.newInstance(Book.class);
        // 创建一个Unmarshall对象
        Unmarshaller unmar = context.createUnmarshaller();
        InputStream is = this.getClass().getResourceAsStream("/book.xml");
        // Unmarshall对象的unmarshal方法可以进行xml到Java对象的转换
        Book book = (Book) unmar.unmarshal(is);
        logger.info(book);
        return book;
    }
}
