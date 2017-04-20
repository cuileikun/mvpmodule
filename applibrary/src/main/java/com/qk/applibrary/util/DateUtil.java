package com.qk.applibrary.util;

import java.text.SimpleDateFormat;

/**
 * 作者：zhoubenhua
 * 时间：2016-10-31 11:07
 * 功能:日期工具
 */
public class DateUtil {

    public static String getCurrentDate() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        String date = sDateFormat.format(new java.util.Date());
        return date;
    }
}
