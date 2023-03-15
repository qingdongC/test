package com.example.demo.Thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName
 * @Description
 * @Author chenqingdong
 * @Date 2023/3/8
 * @Version 1.0.0
 */
public class AtomicCountTest extends Thread {
    private AtomicInteger num = new AtomicInteger(0);

    @Override
    public void run() {
        while (num.get() <= 10000) {
            int i = num.getAndIncrement();
            System.out.println(Thread.currentThread().getName() + "："+i);

        }
    }



    public static void main(String[] args) {
        AtomicCountTest test1 = new AtomicCountTest();
        new Thread(test1).start();
        new Thread(test1).start();

    }

}
