package com.example.demo.demo.queue;

/**
 * 队列接口
 *
 * @Author chenqingdong
 * @Date 2021/5/10
 * @Version 1.0.0
 */
public interface Queue {

    /**
     * 入队操作：将元素加入队列尾部，队列尾指针(rear)后移
     * @param o  待加入队列的元素
     * @return 入队成功返回true，入队失败返回false
     */
    boolean enqueue(Object o);

    /**
     * 出队操作：返回队列头部元素，队列头指针（front)后移
     * @return
     */
    Object dequeue();

    /**
     * 队列长度
     * @return 队列中元素的个数
     */
    int size();

    /**
     * 打印队列
     * @param
     * @return void
     * @Author chenqingdong
     * @Date 2021/11/18 16:39
     **/
    void showQueue();

    /**
     * 查看队列的头部
     * @param
     * @return void
     * @Author chenqingdong
     * @Date 2021/11/18 16:40
     **/
    void peek();
}
