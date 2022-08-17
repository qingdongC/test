package com.example.demo.demo;

import lombok.Data;

import java.util.List;

/**
 * @ClassName Node
 * @Description
 * @Author chenqingdong
 * @Date 2021/5/11 15:02
 * @Version 1.0.0
 */
@Data
public class Node {
    private String path;

    private String value;

    private List<Node> children;
}
