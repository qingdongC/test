package com.example.demo.Thread;

import lombok.Data;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @ClassName
 * @Description
 * @Author chenqingdong
 * @Date 2023/3/6
 * @Version 1.0.0
 */
public class MyExecutors {

    private LinkedBlockingDeque<Runnable> deque;

    private boolean isRun = true;

    public MyExecutors(Integer coreThreadPoolSize,Integer queueSize) {
        deque = new LinkedBlockingDeque<>(queueSize);
        for (int i = 0; i < coreThreadPoolSize; i++) {
            new WorkThread().start();
        }
    }

    public boolean execute(Runnable runnable) {
        return deque.offer(runnable);
    }

    public void close() {
        this.isRun = false;
    }

    class WorkThread extends Thread {

        @Override
        public void run() {
            while (isRun || deque.size() > 0) {
                Runnable runnable = deque.poll();
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }



}
