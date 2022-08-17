package com.example.demo.service;

/**
 * @Author: qingdong.chen
 * @Date: 2020/8/6 9:53
 * @Version 1.0
 */
public class GcTest {

    public void test1(){



    }

    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("111");
        }).start();
    }

}
