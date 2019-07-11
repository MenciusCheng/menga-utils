package com.menga.io;

import java.io.File;

/**
 * ## 磁盘操作
 *
 * File 类可以用于表示文件和目录的信息，但是它不表示文件的内容。
 *
 * 从 Java7 开始，可以使用 Paths 和 Files 代替 File。
 */
public class FileDemo {

    /**
     * 递归地列出一个目录下所有文件
     */
    public static void listAllFiles(File dir) {
        if (dir == null || !dir.exists()) {
            return;
        }
        if (dir.isFile()) {
            System.out.println(dir.getName());
            return;
        }
        for (File file : dir.listFiles()) {
            listAllFiles(file);
        }
    }

    public static void main(String[] args) {
        listAllFiles(new File("src/main/java/com/menga"));
    }
}
