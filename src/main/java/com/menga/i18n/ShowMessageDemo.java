package com.menga.i18n;

import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Marvel on 19/03/04.
 */
public class ShowMessageDemo {

    public static void main(String[] args) {
        Locale localeEn = new Locale("en", "US");
        Locale localeZh = new Locale("zh_CN");
        ResourceBundle rbEn = ResourceBundle.getBundle("i18n/message", localeEn, new UTF8Control());
        ResourceBundle rbZh = ResourceBundle.getBundle("i18n/message", localeZh, new UTF8Control());

        System.out.println("us-US:" + rbEn.getString("helloWorld"));
        System.out.println("us-US:" + String.format(rbEn.getString("time"), "08:00"));
        System.out.println("zh-CN：" + rbZh.getString("helloWorld"));
        System.out.println("zh-CN：" + String.format(rbZh.getString("time"), "08:00"));

        System.out.println(new Date().toString());
    }
}
