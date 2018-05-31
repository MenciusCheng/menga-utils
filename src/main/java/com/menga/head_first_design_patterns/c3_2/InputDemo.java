package com.menga.head_first_design_patterns.c3_2;

import java.io.*;

/**
 * Created by Marvel on 2018/5/31.
 */
public class InputDemo {

    public static void main(String[] args) {
        String file = ClassLoader.getSystemResource("one_world").getFile();
        int c;
        try {
            InputStream in = new LowerCaseInputStream(
                    new BufferedInputStream(
                            new FileInputStream(file)));
            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
