package com.menga.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Created by Marvel on 2019/5/14.
 */
public class LocalDateTimeDemo {

    public static void test1() {
        LocalDateTime t1 = LocalDateTime.now();
        LocalDateTime t2 = t1.plusDays(3).minusHours(2);

        System.out.println(DAYS.between(t1.toLocalDate(), t2.toLocalDate()));

        System.out.println(t1.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
        System.out.println(t2.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
        System.out.println(LocalDateTime.of(t2.toLocalDate(), LocalTime.of(18, 0)));

        LocalTime t3 = LocalTime.now();
        System.out.println(t3.format(DateTimeFormatter.ofPattern("HH:mm")));
    }

    public static void testStringToDate() {
        DateTimeFormatter yyyyMMddDTF = DateTimeFormatter.ofPattern("yyyyMMdd");
        DateTimeFormatter hhmmssDTF = DateTimeFormatter.ofPattern("HHmmss");

        LocalDate localDate = LocalDate.parse("20191028", yyyyMMddDTF);
        LocalTime localTime = LocalTime.parse("164020", hhmmssDTF);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
        System.out.println(localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
    }

    public static void main(String[] args) {
        testStringToDate();
    }
}
