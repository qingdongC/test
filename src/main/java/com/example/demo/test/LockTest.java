package com.example.demo.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName LockTest
 * @Description
 * @Author chenqingdong
 * @Date 2022/8/18 11:42
 * @Version 1.0.0
 */
public class LockTest {

    private static int n = 100;

    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            executorService.execute(() -> testLock(finalI));
        }

    }

    private static synchronized void  testLock(int i){
        System.out.println(--n);
//        try {
//            lock.lock();
//            System.out.println(--n);
//        } catch (Exception e){
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }


    }


}
