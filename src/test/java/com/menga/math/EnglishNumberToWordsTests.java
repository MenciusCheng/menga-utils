package com.menga.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.menga.math.EnglishNumberToWords.convert;

/**
 * Created by Marvel on 2019/6/27.
 */
class EnglishNumberToWordsTests {

    @Test
    void test1() {
        assertEquals("zero", convert(0));
        assertEquals("one", convert(1));
        assertEquals("sixteen", convert(16));
        assertEquals("one hundred", convert(100));
        assertEquals("one hundred eighteen", convert(118));
        assertEquals("two hundred", convert(200));
        assertEquals("two hundred nineteen", convert(219));
        assertEquals("eight hundred", convert(800));
        assertEquals("eight hundred one", convert(801));
        assertEquals("one thousand three hundred sixteen", convert(1316));
        assertEquals("one million", convert(1000000));
        assertEquals("two million", convert(2000000));
        assertEquals("three million two hundred", convert(3000200));
        assertEquals("seven hundred thousand", convert(700000));
        assertEquals("nine million", convert(9000000));
        assertEquals("nine million one thousand", convert(9001000));
        assertEquals("one hundred twenty three million four hundred fifty six thousand seven hundred eighty nine", convert(123456789));
        assertEquals("two billion one hundred forty seven million four hundred eighty three thousand six hundred forty seven", convert(2147483647));
        assertEquals("three billion ten", convert(3000000010L));
    }
}
