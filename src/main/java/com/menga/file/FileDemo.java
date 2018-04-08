package com.menga.file;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;

import static com.menga.utils.PrintUtils.p;

/**
 * Created by Marvel on 2018/1/16.
 */
public class FileDemo {

    public static void main(String[] args) throws Exception {

        URL url = ClassLoader.getSystemResource("json/a.json");
        p("filePath=", url.getFile());

        InputStream in = new FileInputStream(url.getFile());
        int size = in.available();

        p("size=", String.valueOf(size));
//        for (int i = 0; i < size; i++) {
//            System.out.println((char)in.read());
//        }
        byte[] bs = new byte[size];

        in.read(bs);
        in.close();

        char[] cs = new char[size];
        for (int i = 0; i < bs.length; i++) {
            cs[i] = (char) bs[i];
        }

        System.out.println(new String(cs));

    }
}
