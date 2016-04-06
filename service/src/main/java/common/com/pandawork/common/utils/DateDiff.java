package com.pandawork.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chant on 2016/4/6.
 */
public class DateDiff {
    public static long getDiff(Date d1,Date d2){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        long diff = d1.getTime() - d2.getTime();
        if (diff < 0){
            diff = (-diff)/1000;
        }
        return diff;
    }

    public static long getDays(Date d1,Date d2){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            d2 = df.parse(df.format(d2));
            d1 = df.parse(df.format(d1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long diff = d1.getTime() - d2.getTime();
        if (diff < 0){
            diff = (-diff)/(1000*60*60*24);
        }
        return diff;
    }

    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date d2 = null;
        try {
            d2 = df.parse("2004-01-2 07:30:40");
            Date d1 = df.parse("2004-01-01 23:30:24");
            System.out.println(getDiff(d1,d2));

            System.out.println(getDays(d1,d2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
