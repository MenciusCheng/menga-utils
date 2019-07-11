package com.menga.io;

import java.io.*;

/**
 * Created by Marvel on 2019/7/10.
 */
public class InputStreamDemo {

    /**
     * 文件复制
     */
    public static void copyFile(String src, String dist) throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dist));

        byte[] buffer = new byte[20 * 1024];
        int cnt;

        // read() 最多读取 buffer.length 个字节
        // 返回的是实际读取的个数
        // 返回 -1 的时候表示读到 eof，即文件尾
        while ((cnt = in.read(buffer, 0, buffer.length)) != -1) {
            out.write(buffer, 0, cnt);
        }

        in.close();
        out.close();
    }

    /**
     * 实现逐行输出文本文件的内容
     */
    public static void readFileContent(String filePath) throws IOException {

        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        // 装饰者模式使得 BufferedReader 组合了一个 Reader 对象
        // 在调用 BufferedReader 的 close() 方法时会去调用 Reader 的 close() 方法
        // 因此只要一个 close() 调用即可
        bufferedReader.close();
    }

    public static void main(String[] args) throws IOException {
//        copyFile("src/main/resources/one_world", "src/main/resources/one_world2");

        readFileContent("src/main/resources/one_world");
    }
}
