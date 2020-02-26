package com.menga.utils;

import com.vdurmont.emoji.EmojiParser;

public class StringDemo {

    public static void main(String[] args) {

        String s1 = "aaa\nbbb";
        String s2 = "ccc\r\nddd";
        String as1 = EmojiParser.parseToAliases(s1);
        String as2 = EmojiParser.parseToAliases(s2);
        System.out.println(s1);
        System.out.println(s2);

    }
}
