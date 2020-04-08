package com.example.demo;


import java.io.*;
import java.net.*;
import java.nio.charset.Charset;

/**
 * @Author: qingdong.chen
 * @Date: 2019/6/3 13:20
 * @Version 1.0
 */
public class Test {

    @org.junit.Test
    public void test1() {
        System.out.println(12121);
    }

    public static void main(String[] args) {
        byte[] bytes = new byte[100];
        FileOutputStream out = null;
        System.out.println("请输入英文：");
        FileInputStream in = null;
        File file = new File("D://demo/demo.txt");
        try {
            System.in.read(bytes);
            out = new FileOutputStream(file);
//            File file = new File("D://demo.txt");
//            in = new FileInputStream(file);
//            in.read(bytes);
//            for (byte aByte : bytes) {
//                System.out.print((char)aByte);
//            }
            out.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @org.junit.Test
    public void test2() {
        File file = new File("D://demo");
        if (!file.exists()){
            file.mkdir();
            System.out.println(file.isDirectory());
        }
        File file1 = new File("D://demo/demo1.txt");
        if (!file1.exists()){
            System.out.println("1111");
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(file1.isFile());
        System.out.println(file1.isDirectory());
        System.out.println(file1.getParent());
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
    }

    @org.junit.Test
    public void test3() {
        File file = new File("D:/demo.txt");
        char[] bytes = new char[1024];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
//            BufferedInputStream in = new BufferedInputStream(fileInputStream);
            InputStreamReader ir = new InputStreamReader(fileInputStream,"gbk");
            BufferedReader in = new BufferedReader(ir);
            int len = 0;
            while ((len = in.read(bytes)) != -1){
                System.out.println(new String(bytes,0,len));
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void test4() {
        File file = new File("D:/demo.txt");
        File file1 = new File("D://demo1.txt");
        byte[] bytes = new byte[1024];
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream(file);
            out = new FileOutputStream(file1);
            int len = 0;
            try {
                while ((len = in.read(bytes)) != -1){
                    out.write(bytes,0,len);
                }
                out.flush();
            }catch (IOException e){
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if (in != null){
                    in.close();
                }
                if (out != null){
                    out.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    @org.junit.Test
    public void test5() {
        BufferedReader br = null;
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream("D://demo.txt"), "gbk");
            br = new BufferedReader(reader);
            String s = br.readLine();
            while (s != null){
                System.out.println(s);
                s = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @org.junit.Test
    public void test6() {
        try {
            InetAddress address = InetAddress.getByName("www.qq.com");
            System.out.println(address.getHostName());
            System.out.println(address.getHostAddress());
            System.out.println("=========");
            InetAddress address2 = InetAddress.getByName("10.0.84.153");
            System.out.println(address2.getHostName());
            System.out.println(address2.getHostAddress());
            System.out.println("=====");
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost.getHostName());
            System.out.println(localHost.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void test7() {
        try {
            URL url = new URL("http://localhost:8080/pushOverdueOrder");
            String params = "{\n" +
                    "\"isSpec\":1,\n" +
                    "\"startDate\":\"2019-4-20\",\n" +
                    "\"endDate\":\"2019-4-25\"\n" +
                    "}";
            try {
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                //设置请求的参数
                conn.setRequestMethod("POST");
                conn.setConnectTimeout(5 * 1000);// 设置连接超时时间为5秒
                conn.setReadTimeout(20 * 1000);// 设置读取超时时间为20秒
                conn.setDoOutput(true);    // 使用 URL 连接进行输出，则将 DoOutput标志设置为 true
                conn.setDoInput(true);
                conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                //conn.setRequestProperty("Content-Encoding","gzip");
                conn.setRequestProperty("Content-Length", String.valueOf(params.length()));  //设置请求内容(长度)长度
                OutputStream outStream = conn.getOutputStream();   // 返回写入到此连接的输出流
                outStream.write(params.getBytes());    //将参数写入流中
                outStream.close();//关闭流

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line = "";
                while ((line = bufferedReader.readLine()) != null){
                    System.out.println(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void test8() {
        char a[]={'H','e','l','l','o'};
        String sChar=new String(a,1,4);
        a[1] = 's';
        System.out.println(sChar);
    }
}
