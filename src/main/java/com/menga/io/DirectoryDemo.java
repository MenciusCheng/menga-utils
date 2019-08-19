package com.menga.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Marvel on 2019/8/19.
 */
public class DirectoryDemo {

    private static final Pattern assertPattern = Pattern.compile("^\\s*assert");
    private static final Pattern messagePattern = Pattern.compile("\"(.*)\"");

    public static void listAllFiles(File dir, List<File> files) {
        if (dir == null || !dir.exists()) {
            return;
        }
        files.add(dir);
        if (dir.isFile()) {
            return;
        }
        for (File file : dir.listFiles()) {
            listAllFiles(file, files);
        }
    }

    public static void readFileContent(String filePath) throws IOException {

        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        bufferedReader.close();
    }

    public static void readFileContent(String filePath, List<String> assertLines) throws IOException {

        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (assertPattern.matcher(line).lookingAt()) {
                String message = "";
                Matcher lineMatcher = messagePattern.matcher(line);
                while (lineMatcher.find()) {
                    message = lineMatcher.group(1);
                }

                assertLines.add(line.trim() + "\t" + message);
            }
        }

        bufferedReader.close();
    }

    public static void readAllAssert(String filePath) throws IOException {
        List<File> files = new ArrayList<>();
        File dir = new File(filePath);
        listAllFiles(dir, files);

        List<String> assertLines = new ArrayList<>();

        for (File f : files) {
//            System.out.println(f.toString());
            if (f.isFile()) {
                readFileContent(f.toString(), assertLines);
            }
        }

        for (String s : assertLines) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> projects = new ArrayList<>();
        List<String> paths = new ArrayList<>();

        projects.add("ipolymer-productdb-basic-service");
        paths.add("D:\\Workspace\\ipolymer-productdb-basic-service\\src\\main\\scala\\com\\ipolymer\\soa\\productdb\\scala");


        for (int i = 0; i < projects.size(); i++) {
            System.out.println(projects.get(i));
            readAllAssert(paths.get(i));
        }
    }
}
