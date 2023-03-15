package com.example.demo.Thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName
 * @Description
 * @Author chenqingdong
 * @Date 2023/3/8
 * @Version 1.0.0
 */
public class CasLock {

    private AtomicInteger counter = new AtomicInteger(0);

    private Thread currentThread;

    public boolean lock(int retryNum){
        int i = 0;
        while (true) {
            boolean lock = counter.compareAndSet(0, 1);
            if (lock) {
                currentThread = Thread.currentThread();
            }
            if (lock || i >= retryNum){
                return lock;
            }
            i++;
        }


    }

    public boolean unLock(){
        if (currentThread != Thread.currentThread()) {
            return false;
        }
        return counter.compareAndSet(1,0);
    }


    public static void main(String[] args) {
        CasLock lock = new CasLock();
        IntStream.range(0, 10).forEach(i -> {
            new Thread(() -> {
                boolean flag = lock.lock(111120);
                if (flag) {
                    try {
                        System.out.println(Thread.currentThread().getName() +"：获取锁成功：" + i);
                    }catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        boolean unLock = lock.unLock();
                        if (unLock) {
                            System.out.println(Thread.currentThread().getName() +"：释放锁成功：" + i);
                        } else {
                            System.out.println(Thread.currentThread().getName() +"：释放锁失败：" + i);
                        }
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() +"：获取锁失败：" + i);
                }


            }).start();
        });
    }
}
