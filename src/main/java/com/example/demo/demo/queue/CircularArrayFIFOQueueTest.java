package com.example.demo.demo.queue;

import java.util.Scanner;

/**
 * xx类
 *
 * @Author chenqingdong
 * @Date 2021/5/10
 * @Version 1.0.0
 */
public class CircularArrayFIFOQueueTest {
    public static void main(String[] args) {
        Queue queue = new CircularArrayFIFOQueue(4);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        char selection = ' ';
        while(loop) {
            System.out.println("s(show)打印队列");
            System.out.println("a(add)添加数据");
            System.out.println("g(get)获取数据");
            System.out.println("p(peek)查看队列的头部");
            System.out.println("q(exit)退出程序");
            System.out.print("请输入你的选择：");
            selection = scanner.next().trim().charAt(0);
            switch (selection) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    try {
                        System.out.print("请输入要添加的数据：");
                        String value = scanner.next();
                        queue.enqueue(value);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        Object value1 = queue.dequeue();
                        System.out.printf("获取到的数据为："+value1.toString());
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'p':
                    try {
                        queue.peek();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'q':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }
}
