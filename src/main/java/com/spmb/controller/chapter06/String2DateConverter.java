package com.spmb.controller.chapter06;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: leiyulin
 * @date: 2018/6/7
 */
public class String2DateConverter implements Converter<String, Date> {
    private String datePattern;

    private static final Log logger = LogFactory.getLog(String2DateConverter.class);
    @Override
    public Date convert(String source) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
            logger.info(datePattern);
            logger.info(source);
            //将日期字符串转换成Date类型
            return dateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("日期转换失败");
            return null;
        }
    }

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }
}
