package com.example.demo;

import org.junit.Test;

import javax.xml.transform.Source;
import java.util.Arrays;

/**
 * @ClassName ArithmeticTest
 * @Description
 * @Author chenqingdong
 * @Date 2021/11/25 15:33
 * @Version 1.0.0
 */
public class ArithmeticTest {

    /**
     * 二分法
     * @param
     * @return void
     * @Author chenqingdong
     * @Date 2021/11/25 15:34
     **/
    @Test
    public void test1() {
        int[] arr = {1,2,3,4,5,6};
        int index = UtilsTest.dichotomy(arr, 2);
        System.out.println(index);
    }

    @Test
    public void test2() {
        int[] arr = {3,2,1,7,6,5,4};
        arr = UtilsTest.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test3() {
        int[] arr = {3,1,2,5,4,7,6};
        arr = UtilsTest.insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4() {
        int[] array={2,1};
        int i,j,temp;
        for(i=1;i<array.length;i++) {
            /*
             * 第一个for循环
             * 把数组分成两部分，右边为未排序，左边为已排序
             * 记录排序与未排序分割点temp（temp为下一个排序对象）
             */
            temp=array[i];
            for(j=i-1;j>=0;j--) {
                /*
                 * 第二个for循环
                 * 将排序对象temp与已排序数组比较
                 * 当temp比最近左边的数大时（按从小到大循序排列时）
                 * 直接结束本次循环，进行下一个数排序
                 * 否则比左边这个数小时将这个数后移，腾出这个数的位置
                 */
                if (temp > array[j]) {
                    break;
                }else{
                    array[j+1] = array[j];
                }
                System.out.println(j);
            }
            System.out.println(j);
            array[j+1]=temp;
        }
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void test5() {
        //二分法
        int[] arr = {1,2,4,5,7};
        int b = 4;

        int lo = 0;
        int hi = arr.length - 1;
        int mid;
        while (lo <= hi) {
            mid = (lo + hi)/2;
            if (b == arr[mid]){
                System.out.println(mid);
                return;
            } else if (b > arr[mid]){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
    }

    @Test
    public void test6() {
        //冒泡排序
        int[] arr = {3,4,1,5,2,7,8,6};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int temp;
                if (arr[i] > arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    System.out.println(Arrays.toString(arr));
                }
            }
        }
    }

    @Test
    public void test7() {
        int[] arr = {1,3,4,5,7,8,9};
        int tag = 4;
        int lo = 0;
        int hi = arr.length - 1;
        int mid;
        while (lo <= hi){
            mid = (lo + hi) / 2;
            if (tag == arr[mid]){
                System.out.println(mid);
                return;
            } else if (tag > arr[mid]){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
    }

    @Test
    public void test8() {
        int[] arr = {3,1,2,8,5,7,9,4};
        int n = arr.length - 1;
        for (int i = 0; i < n; i++) {  //表名n次排序
            for (int j = 0; j < n - i; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.println("第"+(i+1)+"次排序："+Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
    }
}
