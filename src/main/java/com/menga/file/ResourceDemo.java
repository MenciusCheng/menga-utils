package com.menga.file;

/**
 * 比较 Class.getResource 和 ClassLoader.getResource
 *
 * Created by Marvel on 19/02/13.
 */
public class ResourceDemo {

    public static void main(String[] args) {
        System.out.println("====== Class.getResource(String name) ======");
        // 从当前类所在的包目录查找
        System.out.println(ResourceDemo.class.getResource(""));
        System.out.println(ResourceDemo.class.getResource("testResource.properties"));
        // 以 / 开头则从 classpath 根目录下开始查找
        System.out.println(ResourceDemo.class.getResource("/testResource.properties"));
        System.out.println(ResourceDemo.class.getResource("/files/testResource.properties"));
        // 提示：Class.getResource 和 Class.getResourceAsStream 在使用时，路径选择上是一样的。

        System.out.println("====== Class.getClassLoader().getResource(String name) ======");
        // 从 classpath 根目录下开始查找
        System.out.println(ResourceDemo.class.getClassLoader().getResource(""));
        System.out.println(ResourceDemo.class.getClassLoader().getResource("testResource.properties"));
        // 需要全路径
        System.out.println(ResourceDemo.class.getClassLoader().getResource("files/testResource.properties"));
        // 不能以 / 开头
        System.out.println(ResourceDemo.class.getClassLoader().getResource("/testResource.properties"));
    }
}
