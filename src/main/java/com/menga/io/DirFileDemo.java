package com.menga.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Marvel on 2019/8/19.
 */
public class DirFileDemo {

    public static void main(String[] args) throws IOException {


        Path p = Paths.get("D:\\Workspace\\ipolymer-productdb-basic-service\\src\\main\\scala\\com\\ipolymer\\soa\\productdb\\scala");

        Stream<Path> items = Files.list(p);

        items.forEach(item -> {
            System.out.println(item.getFileName());
        });

        List<Path> result = new ArrayList<Path>();

        Files.walkFileTree(p, new SimpleFileVisitorPath(result));

        for (Path r : result) {
            System.out.println(r.getFileName());
        }
    }

    public static class SimpleFileVisitorPath extends SimpleFileVisitor<Path> {
        private List<Path> result;
        public SimpleFileVisitorPath(List<Path> result){
            this.result = result;
        }
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){
//            if(file.toString().endsWith(".java")){
                result.add(file.getFileName());
//            }
            return FileVisitResult.CONTINUE;
        }
    }
}
