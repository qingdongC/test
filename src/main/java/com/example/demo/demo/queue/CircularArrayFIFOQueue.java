package com.example.demo.demo.queue;

import java.util.Arrays;

/**
 * xx类
 *
 * @Author chenqingdong
 * @Date 2021/5/10
 * @Version 1.0.0
 */
public class CircularArrayFIFOQueue implements Queue {
    /**
     * 环形数组大小上限
     */
    private static final int MAX_ARRAY_SIZE = 65536;

    /**
     * 环形数组，存放队列元素
     */
    private Object[] items;

    /**
     * 队列头部（在items中）的下标
     */
    private int front;

    /**
     * 队列尾部（在items中）的下标
     */
    private int rear;

    /**
     * 环形数组的长度
     */
    private int length;

    /**
     * 队列长度（items中元素的个数）
     */
    private int size;

    public CircularArrayFIFOQueue(int initQueueSize){
        if (initQueueSize > MAX_ARRAY_SIZE){
            throw new RuntimeException("初始化长度过长");
        }
        this.length = initQueueSize;
        items = new Object[length];
        front = -1;
        rear = -1;
        size = 0;
    }

    @Override
    public boolean enqueue(Object o) {
        if (isFull()){
            throw new RuntimeException("队列已满，无法添加");
        }
        rear = (++rear)%length;
        items[rear] = o;
        size++;
        return true;
    }

    @Override
    public Object dequeue() {
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        front = (++front)%length;
        size--;
        return items[front];
    }

    @Override
    public int size() {
        return 0;
    }

    public boolean isEmpty(){
        return size == 0 ? true : false;
    }

    public boolean isFull(){
        return size == length;
    }

    @Override
    public void showQueue() {
        System.out.println(Arrays.asList(items));
    }

    @Override
    public void peek() {
        System.out.println(front);
        System.out.println(Arrays.asList(items[front]));
    }
}
