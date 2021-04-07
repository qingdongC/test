package com.example.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * xx类
 *
 * @Author chenqingdong
 * @Date 2020/11/17
 * @Version 1.0.0
 */
public class DataTest {
    public static void main(String[] args) {
        int[] arr = {6,3,9,2,8,5};
//        method1();
//        arr = bubbleSort(arr);
//        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
//        System.out.println(list);
//        int[] arr = {0,1,2,3};
        int i = dichotomyQuery(arr, 3);
//        System.out.println(i);

    }

    private static void method1(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }

    /**
     * 冒泡排序
     *
     * @param arr
     * @return
     */
    private static int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        /*
           n=6
           5+4+3+2+1  = 15   6*(5/2)
         */
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                int a = arr[j];
                int b = arr[j + 1];
                if (a < b) {
                    arr[j + 1] = a;
                    arr[j] = b;
                }
            }
        }
        return arr;
    }

    /**
     * 二分法
     * @param arr
     * @param target
     * @return
     */
    public static int dichotomyQuery(int[] arr,int target) {
        int low = 0;
        int hight = arr.length - 1;
        int index;
        while (low <= hight){
            index = (low + hight)/2;
            if (arr[index] == target){
                return index;
            } else if (target < arr[index]){
                hight = index - 1;
            } else {
                low = index + 1;
            }
        }
        return -1;
    }
    /**
     * 等额本息还款的意思就是借款人每个月按照相等的金额来偿还贷款本息，
     * 每个月的贷款利息按照月初剩余贷款本金来计算。每月还款额的计算公式为：
     * 每月还款额=贷款本金×[月利率×(1+月利率) ^ 还款月数]÷{[(1+月利率) ^ 还款月数]-1}。
     *
     * 假设借1万元，贷款期限为2年，年利率为5.4%，月利率为4.5‰，
     * 按照等额本息还款法还款每月应还
     * 10000×[4.5‰×(1+4.5‰) ^ 24]÷{[(1+4.5‰) ^ 24]-1}=440.51元。
     * 570000×[6.125‰×(1+6.125‰) ^ 156]÷{[(1+6.125‰) ^ 156]-1}
     *
     * 0.005104 * 1.005104^204 * 570000 / (1.005104^204 - 1)
     */


}
