package com.dzeep.dzframe.DZConverter;

import ognl.DefaultTypeConverter;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * Created by fighting on 15/9/14.
 * 时间类型转化
 */
public class DZDateTimeConverter extends DefaultTypeConverter {
    private DateFormat[] dateFormats = {
            new SimpleDateFormat("yyyy-MM-dd"),
            new SimpleDateFormat("yyyy/MM/dd"),
            new SimpleDateFormat("yy-MM-dd")
    };

    private DateFormat[] timeFormats = {
            new SimpleDateFormat("HH:mm:ssss"),
            new SimpleDateFormat("HH:mm:ss")
    };

    @Override
    public Object convertValue(Map context, Object value, Class toType) {
        if (String.class.equals(toType)){
            if (value instanceof Date ){
                return null;
            }else if (value instanceof Time){
                return null;
            }else if (value instanceof java.util.Date ){
                return dateFormats[0].format((java.util.Date)value);
            }
            return null;
        }

        String[] parameterValues = (String[])value;
        if (Date.class.equals(toType)){
            for (DateFormat format : dateFormats){
                try {
                    return new Date(format.parse(parameterValues[0]).getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }else if (Time.class.equals(toType)){
            for (DateFormat format : timeFormats){
                try {
                    return new Time(format.parse(parameterValues[0]).getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }else if (java.util.Date.class.equals(toType)) {
            for (DateFormat format : dateFormats){
                try {
                    return format.parse(parameterValues[0]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return super.convertValue(context,value,toType);
    }
}
