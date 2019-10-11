package com.menga.regex;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Marvel on 2019/8/19.
 */
public class RegexDemo {

    public boolean isWord(char c) {
        Pattern w = Pattern.compile("[a-zA-Z0-9]");
        return w.matcher(String.valueOf(c)).matches();
    }

    public static void main(String[] args) {
        System.out.println(new RegexDemo().isWord('['));

        Pattern as = Pattern.compile("^\\s*assert");
        Pattern bs = Pattern.compile(".*\"(.*)\"");


//        String s = "  assert(request.category.isNotEmpty, \"category is null\")";
//
//        Pattern as = Pattern.compile("^\\s*assert");
//        Pattern bs = Pattern.compile(".*\"(.*)\"");
//
//        System.out.println(as.matcher(s).lookingAt());
//
//        Matcher matcher = bs.matcher(s);
////        matcher.lookingAt();
//        while (matcher.find()) {
//            System.out.println(matcher.group(1));
//        }
    }
}
