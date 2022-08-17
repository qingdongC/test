package com.example.demo;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName UtilsTest
 * @Description
 * @Author chenqingdong
 * @Date 2021/11/25 15:34
 * @Version 1.0.0
 */
public class UtilsTest {

    /**
     * 二分法
     * @param arr
     * @param a
     * @return int
     * @Author chenqingdong
     * @Date 2021/11/25 16:00
     **/
    public static int dichotomy(int[] arr, int a){
        int lo = 0;
        int hi = arr.length - 1;
        int mid;
        while (lo <= hi){
            mid = (lo+ hi)/2;
            if (a == arr[mid]){
                return mid;
            } else if (a > arr[mid]){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 冒泡排序,升序
     * @param arr
     * @return int
     * @Author chenqingdong
     * @Date 2021/11/25 16:01
     **/
    public static int[] bubbleSort(int[] arr){
        int n = arr.length -1;
        for (int i = 0; i < n; i++) { //外层循环控制排序趟数
            for (int j = 0; j < n - i; j++) {//内层循环控制比较次数
                if (arr[j] > arr[j + 1]){
                   int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = temp;
                }
            }
            System.out.println("第"+(i+1)+"趟排序："+Arrays.toString(arr));
        }
        return arr;
    }

    /**
     * 插入排序算法
     * @param arr
     * @return int
     * @Author chenqingdong
     * @Date 2021/11/25 19:00
     **/
    public static int[] insertSort(int[] arr){
        //待插入的数据
        int value;
        //带插入数据的前一个索引
        int index;
        for (int i = 1; i < arr.length; i++) {
            //待插入数据
            value = arr[i];
            //带插入数据的前一个索引
            index = i - 1;
            // 索引有效且待插入数据小于前一个数据
            while (index >=0 && value < arr[index]){
                //前面数据后移
                arr[index+1] = arr[index];
                //索引-1，继续判断前面的数据
                index--;
            }
            //循环结束，表示找到合适的插入位置，把数据放到空位上
            arr[index + 1] = value;
        }
        return arr;
    }
}
