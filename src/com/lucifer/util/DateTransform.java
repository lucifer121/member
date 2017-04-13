package com.lucifer.util;

import java.sql.Date;

/**
 * Created by zhangchuanqiang on 2017/4/6.
 * java.util.Date和java.sql.Date相互转化
 */
public class DateTransform {
    /**
     * java.util.Date转java.sql.Date
     * @param date
     * @return
     */
    public static Date toSqlDate(java.util.Date date) {

        Date sqlDate = new Date(date.getTime());
        return sqlDate;
    }

    /**
     * java.sql.Date转 java.util.Date
     * @param date
     * @return
     */
    public static java.util.Date toUtilDate(Date date) {

        java.util.Date d = new java.util.Date(date.getTime());
        return d;
    }
}
