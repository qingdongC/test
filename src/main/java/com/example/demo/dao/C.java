package com.example.demo.dao;

import lombok.Data;

/**
 * @ClassName C
 * @Description
 * @Author chenqingdong
 * @Date 2023/1/18 10:10
 * @Version 1.0.0
 */
@Data
public class C {
    private int c1;
    private String c2;

    private void m1(){
        System.out.println("111");
    }

    public static class D{
        private int d1;
        private String d2;

        private void m2() {
            C c = new C();
            c.m1();

        }
    }
}
