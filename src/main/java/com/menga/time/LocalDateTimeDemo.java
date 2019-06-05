package com.menga.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Marvel on 2019/5/14.
 */
public class LocalDateTimeDemo {

    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.now();
        LocalDateTime t2 = time.plusDays(3);
        String timeStr = time.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        System.out.println(timeStr);
        System.out.println(t2.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
    }
}
