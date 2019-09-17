package com.menga.leetcode;

/**
 * Created by Marvel on 2019/9/17.
 */
public class StringCode {

    /**
     * 验证回文串
     */
    public boolean isPalindrome(String s) {
        int p1 = 0;
        int p2 = s.length() - 1;
        while (p1 < p2) {
            if (s.charAt(p1++) != s.charAt(p2--)) {
                return false;
            }
        }
        return true;
    }


    /**
     * 验证回文串（只考虑字母和数字字符，可以忽略字母的大小写）
     */
    public boolean isPalindrome2(String s) {
        int p1 = 0;
        int p2 = s.length() - 1;
        boolean flag = true;
        while (p1 < p2) {
            char c1 = Character.toUpperCase(s.charAt(p1));
            if (isNotWord(c1)) {
                p1++;
                continue;
            }
            char c2 = Character.toUpperCase(s.charAt(p2));
            if (isNotWord(c2)) {
                p2--;
                continue;
            }
            if (c1 != c2) {
                flag = false;
                break;
            }
            p1++;
            p2--;
        }
        return flag;
    }

    private boolean isNotWord(char c) {
        return !(('0' <= c && c <= '9') || ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z'));
    }

    private char upperCase(char c) {
        if ('a' <= c && c <= 'z') {
            return (char) (c - 32);
        }
        return c;
    }

    public static void main(String[] args) {
        // 验证回文串（只考虑字母和数字字符，可以忽略字母的大小写）
        System.out.println(new StringCode().isPalindrome2("race a car"));
    }
}
