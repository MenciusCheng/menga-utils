package com.menga.string;

import org.junit.jupiter.api.Test;
import java.util.logging.Logger;


/**
 * Created by Marvel on 2018/4/9.
 */
public class TestString {

    private static final Logger LOG = Logger.getLogger(TestString.class.getName());

    @Test
    void test1() {
        String s = "{12345}";
        int c = 125;
        System.out.println(s.lastIndexOf(c));
        System.out.println(s.substring(0,6));
    }
}
