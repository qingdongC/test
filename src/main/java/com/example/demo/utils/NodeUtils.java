package com.example.demo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.demo.Node;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @ClassName NodeUtils
 * @Description
 * @Author chenqingdong
 * @Date 2021/5/11 15:05
 * @Version 1.0.0
 */
public class NodeUtils {

    public static Node getNode(List<Node> nodes, String path){
        if (StringUtils.isBlank(path)){
            return null;
        }
        if (nodes == null || nodes.size() == 0){
            return null;
        }
        for (Node node : nodes) {
            if (path.equals(node.getPath())){
                return node;
            }
            Node nd = getNode(node.getChildren(), path);
            if (nd != null){
                return nd;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String jsonStr = "[\n" +
                " {\n" +
                " \"path\": \"level0_0/\",\n" +
                " \"value\": \"value\",\n" +
                " \"children\": [\n" +
                " {\n" +
                " \"path\": \"level0_0/level1_0/\",\n" +
                " \"value\": \"value\",\n" +
                " \"children\": [\n" +
                " {\n" +
                " \"path\": \"level0_0/level1_0/level2_0\",\n" +
                " \"value\": \"value\",\n" +
                " \"children\": []\n" +
                " },\n" +
                " {\n" +
                " \"path\": \"level0_0/level1_0/level2_1\",\n" +
                " \"value\": \"value\",\n" +
                " \"children\": []\n" +
                " },\n" +
                " {\n" +
                " \"path\": \"level0_0/level1_0/level2_1\",\n" +
                " \"value\": \"value\",\n" +
                " \"children\": []\n" +
                " }\n" +
                " ]\n" +
                " },\n" +
                " {\n" +
                " \"path\": \"level0_0/level1_1/\",\n" +
                " \"value\": \"value\",\n" +
                " \"children\": [\n" +
                " {\n" +
                " \"path\": \"level0_0/level1_1/level2_0\",\n" +
                " \"value\": \"value\",\n" +
                " \"children\": []\n" +
                " },\n" +
                " {\n" +
                " \"path\": \"level0_0/level1_1/level2_1\",\n" +
                " \"value\": \"value\",\n" +
                " \"children\": []\n" +
                " },\n" +
                " {\n" +
                " \"path\": \"level0_0/level1_1/level2_1\",\n" +
                " \"value\": \"value\",\n" +
                " \"children\": []\n" +
                " }\n" +
                " ]\n" +
                " }\n" +
                " ]\n" +
                " },\n" +
                " {\n" +
                " \"path\": \"level0_1/\",\n" +
                " \"value\": \"avaluerg\",\n" +
                " \"children\": []\n" +
                " } ]";


        List<Node> nodes = JSON.parseArray(jsonStr, Node.class);
        Node node = getNode(nodes, "level0_0/level1_0/level2_1");
        System.out.println(JSON.toJSONString(node));

    }
}
