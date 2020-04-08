package com.example.demo.constant;

/**
 * @Author: qingdong.chen
 * @Date: 2019/9/19 10:38
 * @Version 1.0
 */
public abstract class DemoAbstract implements DemoInterface{

    public abstract Book get(Integer id);

    @Override
    public Book  query(Integer id){
        Book book = new Book();
        book.setId(id);
        return book;
    }
}
