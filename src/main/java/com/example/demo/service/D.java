package com.example.demo.service;

import java.time.temporal.Temporal;

/**
 * @ClassName D
 * @Description
 * @Author chenqingdong
 * @Date 2021/5/11 9:46
 * @Version 1.0.0
 */
public class D extends GcTest implements C {
    @Override
    public int method1(int a, int b) {
        return a;
    }

    public static void test(Object o){
        return;
    }

    public static void main(String[] args) {
        D d = new D();
        test("s");
    }





}
