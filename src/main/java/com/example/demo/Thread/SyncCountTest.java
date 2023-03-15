package com.example.demo.Thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName
 * @Description
 * @Author chenqingdong
 * @Date 2023/3/7
 * @Version 1.0.0
 */
public class SyncCountTest extends Thread{
    private Integer num = 0;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (num >= 10000) {
                    break;
                }
                num++;
                System.out.println(Thread.currentThread().getName() +"：" + num);
            }
        }

    }


    public static void main(String[] args) {
        SyncCountTest countTest = new SyncCountTest();
        new Thread(countTest).start();
        new Thread(countTest).start();
        //new CountTest().start();
    }
}
