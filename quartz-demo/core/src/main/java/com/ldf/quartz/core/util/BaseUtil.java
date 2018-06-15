package com.ldf.quartz.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by ldf on 2018/4/19.
 */
public class BaseUtil {

    /**
     * uuid
     * @return
     */
    public static String createUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 字符串转Date
     * @param dateStr
     * @return
     * @throws ParseException
     */
    public static Date strToDate(String dateStr) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return format.parse(dateStr);
    }

    /**
     * 获取当前时间
     * @return
     */
    public static String getNowStr(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }

    /**
     * list转成指定字符间隔的字符串
     * @param list
     * @param intervalSign 间隔符
     * @return
     */
    public static String listToStr(List<String> list, String intervalSign){
        String result = "";
        for(String item : list){
            result += item + intervalSign;
        }
        return result.substring(0,result.length()-1);
    }

    /**
     * 如果集合为空返回true
     * @param collection
     * @return
     */
    public static Boolean collectEmpty(Collection collection){
        if(collection != null && collection.size() > 0) return false;
        return true;
    }

    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static Boolean isEmpty(String str){
        if(str == null || str.trim() == "") return true;
        return false;
    }

    /**
     * 判断两个字符创是否相同
     * @param str1
     * @param str2
     * @return
     */
    public static Boolean strSame(String str1, String str2){
        return str1.equals(str2);
    }

    public static void main(String[] args){
        System.out.println(getNowStr());
    }

}
