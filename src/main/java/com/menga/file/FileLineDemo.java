package com.menga.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marvel on 18/11/12.
 */
public class FileLineDemo {

    public static void main(String[] args) throws IOException {
        InputStream in = ClassLoader.getSystemResourceAsStream("files/divisionCode.sql");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        List<String> lines = new ArrayList<>();
        String str;
        while ((str = reader.readLine()) != null) {
            if (str.length() > 0) {
                String p = str.substring(0, 34);

                int index = str.indexOf("`division_code`");

                String e = str.substring(str.indexOf("`division_code`"), str.length());

                lines.add(p + e);
            }
        }

        for (String line : lines) {
            System.out.println(line);
        }
    }
}
