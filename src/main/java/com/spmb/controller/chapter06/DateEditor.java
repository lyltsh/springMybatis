package com.spmb.controller.chapter06;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: leiyulin
 * @date: 2018/6/7
 */
public class DateEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateFormat.parse(text);
            setValue(date);
        }catch (ParseException e){
            e.getErrorOffset();
        }
    }
}
