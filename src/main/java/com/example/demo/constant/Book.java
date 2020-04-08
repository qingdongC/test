package com.example.demo.constant;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @Author: qingdong.chen
 * @Date: 2019/5/31 15:31
 * @Version 1.0
 */
public class Book {

    public int Id;    //图书编号
    private String Name;    //图书名称
    private int Price;    //图书价格
    private BigDecimal accmount;

    public BigDecimal getAccmount() {
        return accmount;
    }

    public void setAccmount(BigDecimal accmount) {
        this.accmount = accmount;
    }

    public Book(){

    }
    public Book(int id,String name,int price)
    {    //构造方法
        this.Id=id;
        this.Name=name;
        this.Price=price;
    }
    @Override
    public String toString()
    {    //重写 toString()方法
        return this.Id+", "+this.Name+"，"+this.Price;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
}
