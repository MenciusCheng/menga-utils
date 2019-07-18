package com.menga.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Marvel on 2019/7/18.
 */
public class ConsoleDemo {

    /**
     * 从控制台中读取输入行
     */
    public static void readConsole() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (true) {
            line = br.readLine();
            if ("quit".equals(line)) {
                System.out.println("Quit!");
                break;
            } else {
                System.out.println("Your input is: " + line);
            }
        }
        br.close();
    }

    public static void main(String[] args) throws IOException {
        readConsole();
    }
}
