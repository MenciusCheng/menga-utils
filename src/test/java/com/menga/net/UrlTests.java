package com.menga.net;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Marvel on 18/10/09.
 */
public class UrlTests {

    /**
     * 输出方法
     */
    @Test
    void test1() throws MalformedURLException {
        URL url = new URL("http://www.runoob.com/cc/index.html?language=cn&name=aa#j2se");
        System.out.println("URL 为：" + url.toString());
        System.out.println("协议为：" + url.getProtocol());
        System.out.println("验证信息：" + url.getAuthority());
        System.out.println("文件名及请求参数：" + url.getFile());
        System.out.println("主机名：" + url.getHost());
        System.out.println("路径：" + url.getPath());
        System.out.println("端口：" + url.getPort());
        System.out.println("默认端口：" + url.getDefaultPort());
        System.out.println("请求参数：" + url.getQuery());
        System.out.println("定位位置：" + url.getRef());

        // 相对路径
        URL relativeUrl = new URL(url, "bx.html");
        System.out.println("相对路径：" + relativeUrl);

        // 绝对路径
        URL absoluteUrl = new URL(url, "http://www.runoob.com/aa/bx.html");
        System.out.println("绝对路径：" + absoluteUrl);
    }

    /**
     * 读取网站
     */
    @Test
    void test2() throws IOException {
        URL url = new URL("http://www.runoob.com");
        URLConnection urlConnection = url.openConnection();
        HttpURLConnection connection = null;
        if(urlConnection instanceof HttpURLConnection)
        {
            connection = (HttpURLConnection) urlConnection;
        }
        else
        {
            System.out.println("请输入 URL 地址");
            return;
        }
        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        StringBuilder urlString = new StringBuilder();
        String current;
        while((current = in.readLine()) != null)
        {
            urlString.append(current);
            urlString.append("\n");
        }
        System.out.println(urlString);
    }
}
