package com.example.demo;


import com.alibaba.fastjson.support.odps.udf.CodecCheck;
import com.example.demo.constant.Book;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import net.bytebuddy.asm.Advice;
import org.apache.http.client.utils.DateUtils;
import org.apache.http.protocol.HTTP;
import org.junit.Assert;
import org.springframework.format.annotation.DateTimeFormat;
import sun.net.www.http.HttpClient;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Source;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.*;
import java.nio.charset.Charset;
import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

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
        ArrayList<Object> lst = new ArrayList<>();
        List lst1 = new ArrayList();
        lst1.add("add");
        lst1.add("art");
        lst1.add("uio");
        List lst2 = new ArrayList();
        lst2.add("add2");
        lst2.add("art2");
        lst2.add("uio2");
        lst.addAll(lst2);
        lst.addAll(lst1);
        for (Object s : lst) {
            System.out.println(s);
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

    @org.junit.Test
    public void test9() throws InterruptedException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    stringBuffer.append("a");

                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(stringBuffer.length());
    }

    @org.junit.Test
    public void test10() throws InterruptedException {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    stringBuilder.append("a");

                }
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(stringBuilder.length());
    }

    @org.junit.Test
    public void test11() throws InterruptedException, IOException {
        String s = "https://v2.zhaogang.com/#/channel?pageCode=_APP_sales_HDJCQD|||https://v2.zhaogang.com/#/channel?pageCode=_APP_sales_HDZBQD|||https://v2.zhaogang.com/#/channel?pageCode=_APP_sales_HDLDQD";

        String[] split = s.split("\\|\\|\\|");
        for (String s1 : split) {
            System.out.println(s1);
        }
        URL url = new URL("https://www.baidu.com");

    }

    @org.junit.Test
    public void name() {
        int a = 0;
        int c = 0;
        for (int i = 0; i < 99; i++) {
            a = a++;
            c = a++;
        }
        System.out.println(a);
        System.out.println(c);
        int b = 0;
        for (int i = 0; i < 99; i++) {
            b = ++b;
        }
        System.out.println(b);
    }

    @org.junit.Test
    public void name2() {
        Book.inner inner = new Book().new inner();
        inner.priant();
        Book.staticinner staticinner = new Book.staticinner();
        staticinner.priant();
    }

    private Book deal(Book a){
        a = new Book();
        a.setName("2222");
        System.out.println("a:"+a);
        return a;
    }

    @org.junit.Test
    public void name3() {
        ArrayList<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        String[] array = new String[4];
        String[] array1 = list.toArray(array);

        System.out.println(list);
        System.out.println(array1[2]);
        LinkedList<Object> objects = new LinkedList<>();
        HashMap<Object, Object> hashMap = new HashMap<>();
        Hashtable<Object, Object> hashtable = new Hashtable<>();
        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
        Collections.synchronizedCollection(list);
        Vector<Object> objects1 = new Vector<>();
    }

    @org.junit.Test
    public void name4() {
        int a = 8;// 111
        int b = a >>1;//11
        System.out.println(b);
        int c = 1 << a;
        System.out.println(c);
        ArrayList<Object> list = new ArrayList<>(18);
        System.out.println(list.size());
    }

    @org.junit.Test
    public void name5() {
        Set<Integer> set = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(4);
        Collections.sort(list);
        System.out.println(list);
        for (Integer s : list) {
            System.out.println(s);
        }
        TreeMap<Object, Object> objectObjectTreeMap = new TreeMap<>();
        LinkedHashMap<Object, Object> objectObjectLinkedHashMap = new LinkedHashMap<>();
        LinkedHashSet<Object> objects = new LinkedHashSet<>();

        Socket socket = new Socket();

        Book<Object> book = new Book<>();
        Class<? extends Book> aClass = book.getClass();
        Field[] fields = aClass.getDeclaredFields();
        System.out.println(fields.length);
        for (Field field : fields) {
            field.setAccessible(false);
            System.out.println(field.getName());
        }
        try {
            Method method = aClass.getMethod("getId");
            System.out.println(method.invoke(book));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @org.junit.Test
    public void name6() {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(()->{
                try {
                    System.out.println(finalI +"：开始执行！");
                    Thread.sleep(2000);
                    System.out.println(finalI+"：执行结束！");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行结束");
    }

    @org.junit.Test
    public void name7() {
        Semaphore semaphore = new Semaphore(2);
        try {
            for (int i = 0; i < 10; i++) {
                semaphore.acquire();
                int finalI = i;
                new Thread(()->{
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(finalI +"执行完成");
                    semaphore.release();
                }).start();

            }
            System.out.println("主线程执行完成");
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @org.junit.Test
    public void name8() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(8,16,10, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        ArrayList<Future> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Future<String> future = threadPoolExecutor.submit(() ->{
                Thread.sleep(2000);
                return"1212"+ finalI;
            });
            futures.add(future);
        }
        for (Future future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("执行完成");
        myThread myThread = new myThread();
        myThread.start();
        try {
            Thread.sleep(3000);

//            myThread.stop=true;
         myThread.interrupt();

            Thread.sleep(3000);
            System.out.println("结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private synchronized  void  deal(String ... args){
        for (String arg : args) {
            System.out.println(arg);
        }
    }

    class myThread extends Thread{
        private boolean stop = false;

        @Override
        public void run() {
            while (!stop){
                System.out.println(getName()+"开始执行");
                try {
                    Thread.yield();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    stop = true;
                }
            }
            System.out.println(getName()+"执行完成");
        }
    }

    @org.junit.Test
    public void name9() {
        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
        queue.peek();

    }




}
