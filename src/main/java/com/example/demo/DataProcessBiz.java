package com.example.demo;

import java.io.*;

/**
 * @Author: qingdong.chen
 * @Date: 2020/4/30 13:28
 * @Version 1.0
 */
public class DataProcessBiz {

    public static void main(String[] args) {
        dealData("update DWD_BH_ORDER_TWO set CREDIT_NO = '${CREDIT_NO}' where CUSTOMER_NAME = '${CUSTOMER_NAME}';");

//        dealData("insert into qd_advert_site (advert_site_name,add_time) values('${CREDIT_NO}',SYSDATE());");
    }

    public static void dealData(String sql){
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("D:\\MyWorkspace\\test\\src\\main\\resources\\data.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
            try {
                while ((line = bufferedReader.readLine()) != null){
                String[] lineArr = line.split("\t");
                String result = sql.replace("${CREDIT_NO}",lineArr[1]).replace("${CUSTOMER_NAME}",lineArr[0]);
                System.out.println(result);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

    }
}
