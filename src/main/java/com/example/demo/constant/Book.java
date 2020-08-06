package com.example.demo.constant;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: qingdong.chen
 * @Date: 2019/5/31 15:31
 * @Version 1.0
 */
public class Book<D> implements Serializable,Cloneable{

//    private static final long serialVersionUID = -3458026017624423764L;
    /**
     * 图书编号
     */
    public int Id;
    /**
     * 图书名称
     */
    private String Name;
    /**
     * 图书价格
     */
    private int Price;
    private BigDecimal accmount;
    private D d;

    private static int a = 10;

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

    @Override
    public Book clone() {
        Book book = null;
        try {
            book =  (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return book;
    }

    public static class staticinner{
        public void priant(){
            System.out.println(a);
        }
    }



    public class inner{
        public void priant(){
            System.out.println(Id);
            System.out.println(a);
        }
    }
}
