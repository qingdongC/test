package com.example.demo.service.impl;

import com.example.demo.service.FunctionBlankOrNoBlank;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLOutput;

/**
 * @ClassName FunctionServiceImpl
 * @Description
 * @Author chenqingdong
 * @Date 2021/11/25 15:07
 * @Version 1.0.0
 */
public class FunctionServiceImpl {

    public static FunctionBlankOrNoBlank deal(String message){
        return (consumer,runnable) ->{
            if (StringUtils.isBlank(message)){
                runnable.run();
            } else {
                consumer.accept(message);

            }
        };
    }

    public static void main(String[] args) {
        FunctionServiceImpl.deal("").doHandler((a)->{
            System.out.println("执行结果:"+a);
        },()->{
            System.out.println("数据为空");
        });
    }
}
