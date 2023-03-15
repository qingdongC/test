package com.example.demo.Thread;

/**
 * @ClassName
 * @Description
 * @Author chenqingdong
 * @Date 2023/3/12
 * @Version 1.0.0
 */
public class ThreadLocalTest {
    private static ThreadLocal<Object> threadLocal = new ThreadLocal();

    public static void main(String[] args) {
        threadLocal.set("aaa");

        final Object[] o = {threadLocal.get()};
        new Thread(() -> {threadLocal.set("bbb");}).start();
        new Thread(() -> {threadLocal.set("ccc");}).start();
        new Thread(() -> {
            threadLocal.set("ddd");
            o[0] = threadLocal.get();
            //System.out.println(o[0]);
        }).start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(o[0]);
    }
}
