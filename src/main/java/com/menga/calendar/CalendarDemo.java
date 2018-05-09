package com.menga.calendar;

import java.util.Calendar;
import java.util.logging.Logger;

import static com.menga.calendar.SimpleDateFormatDemo.*;

/**
 * Created by Marvel on 2018/5/9.
 */
public class CalendarDemo {

    private static final Logger LOG = Logger.getLogger(CalendarDemo.class.getName());

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(stringToDate("2018-12-31 00:00:00"));

        LOG.info(dateToString(calendar.getTime()));

        calendar.add(Calendar.DATE, 1);

        LOG.info(dateToString(calendar.getTime()));

        calendar.add(Calendar.MILLISECOND, -1);

        LOG.info(dateToString(calendar.getTime()));

        LOG.info(String.valueOf(calendar.get(Calendar.DATE)));
        LOG.info(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
        LOG.info(String.valueOf(calendar.get(Calendar.DAY_OF_YEAR)));
    }
}
