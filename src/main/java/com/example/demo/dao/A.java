package com.example.demo.dao;

import lombok.Data;

/**
 * @ClassName A
 * @Description
 * @Author chenqingdong
 * @Date 2023/1/17 18:40
 * @Version 1.0.0
 */
@Data
public class A {
    private int a1;
    private String a2;

    private void m1() {
        System.out.println(111);
    }

    @Data
    public class B{
        private int b1;
        private String b2;

        public void test(){
            a1 = b1;
            a2 = b2;
            m1();
        }
    }
}

