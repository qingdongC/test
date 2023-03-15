package com.example.demo.Thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName
 * @Description
 * @Author chenqingdong
 * @Date 2023/3/8
 * @Version 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        //SyncCountTest countTest = new SyncCountTest();
        //new Thread(countTest).start();
        //new Thread(countTest).start();

        AtomicInteger num = new AtomicInteger(1);

        new Thread(() -> {
            while (true) {
                if (num.get() > 10000) {
                    break;
                }
                int i = num.getAndIncrement();
                System.out.println(Thread.currentThread().getName() +"：" + i);
            }
        }).start();
        new Thread(() -> {
            while (true) {
                if (num.get() > 10000) {
                    break;
                }
                int i = num.getAndIncrement();
                System.out.println(Thread.currentThread().getName() +"：" + i);
            }
        }).start();
    }
}
