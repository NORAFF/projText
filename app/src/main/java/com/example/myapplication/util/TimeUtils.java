package com.example.myapplication.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {
    public static String Date2String(Date dateDate,String sdf){
        String sdf1=(sdf.equals(""))?"yyyy-MM-dd":sdf;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(sdf1);
        String dateString = simpleDateFormat.format(dateDate);
        return dateString;
    }

    /**
     * 比较时间大小
     * @return
     */
    public static boolean isDateOneBigger(String str1, String str2) {
        boolean isBigger = false;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dt1 = null;
        Date dt2 = null;
        try {
            dt1 = sdf.parse(str1);
            dt2 = sdf.parse(str2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dt1.before(dt2);
    }

    public static String getnext(int days){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, days);
        Date d = ca.getTime();
        String backTime = format.format(d);
        return backTime;
    }
}
