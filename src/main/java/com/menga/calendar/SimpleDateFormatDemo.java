package com.menga.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Created by Marvel on 2018/5/9.
 */
public class SimpleDateFormatDemo {

    private static final Logger LOG = Logger.getLogger(SimpleDateFormatDemo.class.getName());

    public static void main(String[] args) {
        Date date = stringToDate("2018-05-09 00:00:00");
        LOG.info(dateToString(date));
    }

    public static String dateToString(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    public static String dateToString(Date date) {
        return dateToString(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static Date stringToDate(String sDate, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(sDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date stringToDate(String sDate) {
        return stringToDate(sDate, "yyyy-MM-dd HH:mm:ss");
    }
}
