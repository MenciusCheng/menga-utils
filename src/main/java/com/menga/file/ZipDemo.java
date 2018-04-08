package com.menga.file;

import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Marvel on 2018/1/16.
 */
public class ZipDemo {

    private static String A_JSON = ClassLoader.getSystemResource("json/a.json").getFile();
    private static String B_JSON = ClassLoader.getSystemResource("json/b.json").getFile();

    public static void main(String[] args) throws Exception {
//        zipOneFile();
        zipMultipleFiles();
    }

    public static void zipOneFile() throws Exception {
        FileOutputStream fos = new FileOutputStream("a.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);

        File fileToZip = new File(A_JSON);
        FileInputStream fis = new FileInputStream(fileToZip);

        ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
        zipOut.putNextEntry(zipEntry);

        final byte[] bytes = new byte[1024];
        int length;
        while((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        zipOut.close();
        fis.close();
        fos.close();
    }

    public static void zipMultipleFiles() throws Exception {
        List<String> srcFiles = Arrays.asList(A_JSON, B_JSON);
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
        FileOutputStream fos = new FileOutputStream("ab.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);

        for (String srcFile : srcFiles) {
            File fileToZip = new File(srcFile);
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        }
        zipOut.close();
        fos.close();
    }


}
