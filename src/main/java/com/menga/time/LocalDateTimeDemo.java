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

    public static void test() {
        String createdTimeStr = "20191112T215921.000Z";
        LocalDateTime createdTime = toLocalDateTime(createdTimeStr);
        LocalDateTime startTime = createdTime.plusSeconds(3600);
        LocalDateTime endTime = startTime.plusSeconds(14400);
        String remainingTime = timeBetween(System.currentTimeMillis(), endTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        System.out.println(createdTime);
        System.out.println(startTime);
        System.out.println(endTime);
        System.out.println(remainingTime);
    }

    private static LocalDateTime toLocalDateTime(String time) {
        String ts = time.substring(0, 8) + time.substring(9, 15);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime localDateTime = LocalDateTime.parse(ts, dtf);
        return localDateTime.plusHours(7);
    }

    private static String timeBetween(Long start, Long end) {
        int between = (int)((end - start) / 1000);
        int hour = between / 3600;
        int minute = (between - hour * 3600) / 60;

        StringBuilder sb = new StringBuilder();
        if (hour > 0) {
            sb.append(hour).append("小时");
        }
        if (minute > 0) {
            sb.append(minute).append("分钟");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        test();
    }
}
