package com.menga.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Marvel on 2019/5/14.
 */
public class LocalDateTimeDemo {

    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.now();
        String timeStr = time.format(DateTimeFormatter.ofPattern("YYYYMMdd"));
        System.out.println(timeStr);
    }
}
