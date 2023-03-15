package com.example.demo.Thread;

/**
 * @ClassName
 * @Description
 * @Author chenqingdong
 * @Date 2023/3/6
 * @Version 1.0.0
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        MyExecutors executors = new MyExecutors(2, 5);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            boolean execute = executors.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "：" + finalI);
            });
            System.out.println(i +"提交结果：" + execute);
        }
        executors.close();
        Thread.sleep(5000);
    }
}
