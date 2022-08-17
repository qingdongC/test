package com.example.demo.service;

import java.util.function.Consumer;

/**
 * @ClassName FunctionBlankOrNoBlank
 * @Description
 * @Author chenqingdong
 * @Date 2021/11/25 15:04
 * @Version 1.0.0
 */
@FunctionalInterface
public interface FunctionBlankOrNoBlank {

    void doHandler(Consumer consumer, Runnable runnable);
}
