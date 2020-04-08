package com.example.demo.constant;

/**
 * @Author: qingdong.chen
 * @Date: 2019/5/31 13:59
 * @Version 1.0
 */
public enum WeekDay {
    Mon(1,"星期一"),Tue(2,"星期二");
    private int a;
    private String desc;

    WeekDay(int a, String desc) {
        this.a = a;
        this.desc = desc;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }}
