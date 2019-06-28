package com.menga.time;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Created by Marvel on 2019/5/14.
 */
public class LocalDateTimeDemo {

    public static void main(String[] args) {
        LocalDateTime t1 = LocalDateTime.now();
        LocalDateTime t2 = t1.plusDays(3).plusHours(25);

        System.out.println(DAYS.between(t1, t2));

        System.out.println(t1.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
        System.out.println(t2.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
        System.out.println(LocalDateTime.of(t2.toLocalDate(), LocalTime.of(18, 0)));
    }
}
