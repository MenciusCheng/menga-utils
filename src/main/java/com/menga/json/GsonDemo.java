package com.menga.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

import static com.menga.utils.PrintUtils.p;

/**
 * Created by Marvel on 2018/2/8.
 */
public class GsonDemo {

    private static Gson gson = new Gson();

    public static void main(String[] args) {

    }

    private static void testMapJson() {
        Type type = new TypeToken<Map<String, String>>(){}.getType();
        Map m2 = gson.fromJson("{\"a\":\"b\",\"b\":1}", new java.util.HashMap<String, String>().getClass());
        Map m = gson.fromJson("{\"a\":\"b\",\"b\":1}", type);
        p(m.toString());
        p(m2.toString());
    }
}
