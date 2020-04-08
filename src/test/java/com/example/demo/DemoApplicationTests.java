package com.example.demo;

import com.example.demo.constant.AcLoan;
import com.example.demo.constant.Book;
import com.example.demo.constant.Color;
import com.example.demo.constant.ListClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.security.action.PutAllAction;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.math.BigDecimal;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.PublicKey;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import static java.lang.Enum.valueOf;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
        byte[] bytes = new byte[100];
        System.out.println("请输入英文：");
        try {
            System.in.read(bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("你输入的英文如下：");
        for (byte aByte : bytes) {
            System.out.println(aByte);

        }
    }
    @Test
    public void test2(){
        ListClass<ArrayList> listListClass = new ListClass<ArrayList>();
        ListClass<LinkedList> listListClass1 = new ListClass<LinkedList>();

    }

    public void rep(int ... a){

        int[] res = res(a);
        for (int i : res) {
            System.out.println(i);
        }

    }
    public int[] res(int ... a){
        return a;
    }
    @Test
    public void test3(){
        try {
            InputStream in = new FileInputStream("D://test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() {
        int i=10;
        System.out.printf("%x \n\t",~i);
    }

    public static String encryptAndDencrypt(String value, char secret)
    {
        byte[] bt=value.getBytes();    //将需要加密的内容转换为字节数组
        for(int i=0;i<bt.length;i++)
        {
            bt[i]=(byte)(bt[i]^(int)secret);    //通过异或运算进行加密
        }
        String newresult=new String(bt,0,bt.length);    //将加密后的字符串保存到 newresult 变量中
        return newresult;
    }

    @Test
    public void test5() {
        String sip = "127.0.0.1";
        InetAddress ip = null;
        boolean bFindIP = false;
        Enumeration<NetworkInterface> netInterfaces = null;
        try {
            netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        while (netInterfaces.hasMoreElements()) {
            if (bFindIP) {
                break;
            }
            NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
            // 遍历所有ip
            Enumeration<InetAddress> ips = ni.getInetAddresses();
            while (ips.hasMoreElements()) {
                ip = (InetAddress) ips.nextElement();
                if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress() // 127.开头的都是lookback地址
                        && ip.getHostAddress().indexOf(":") == -1) {
                    bFindIP = true;
                    break;
                }
            }
        }
        if (ip != null) {
            sip = ip.getHostAddress();
        }
        System.out.println(sip);
    }

    private static String getLocalIp() {
        String sip = null;
        InetAddress ip = null;
        boolean bFindIP = false;
        Enumeration<NetworkInterface> netInterfaces = null;
        try {
            netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        while (netInterfaces.hasMoreElements()) {
            if (bFindIP) {
                break;
            }
            NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
            // 遍历所有ip
            Enumeration<InetAddress> ips = ni.getInetAddresses();
            while (ips.hasMoreElements()) {
                ip = (InetAddress) ips.nextElement();
                if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress() // 127.开头的都是lookback地址
                        && ip.getHostAddress().indexOf(":") == -1) {
                    bFindIP = true;
                    break;
                }
            }
        }
        if (ip != null) {
            sip = ip.getHostAddress();
        }
        return sip;

    }

    @Test
    public void test6() {
        List<Book> allBooks = new ArrayList<>();
        List<Book> boyBooks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book(i, "name is" + i, i);
            allBooks.add(book);
        }
//        for (int i = 0; i < 5; i++) {
//            Book book = new Book(i, "name is" + i, i);
//            boyBooks.add(book);
//        }
        boyBooks = allBooks.subList(0, 5);
        System.out.println("删除前："+allBooks.size());
        System.out.println(allBooks.removeAll(boyBooks));
        System.out.println("删除hou："+allBooks.size());

    }

    @Test
    public void name() {
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH,0);
        cale.set(Calendar.MINUTE,0);
        cale.set(Calendar.SECOND,0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = simpleDateFormat.format(cale.getTime());
        System.out.println(format);
    }

    @Test
    public void name2() {
        String a ="你ad121，";
        try {
            int length = a.getBytes("gbk").length;
            System.out.println(length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void name3() {
        Object a = "1";
        String[] split = String.valueOf(a).split(",");
        System.out.println(split.length);
        for (String s : split) {
            System.out.println(s);

        }
    }

    @Test
    public void name4() {
        File file = new File("D:/text/1231");
        if (!file.exists()){
            System.out.println(23111);
            file.mkdir();
        } else {
            System.out.println(23112);
        }
        if (file.exists()){
            System.out.println(23113);
            file.delete();
        }
    }

    @Test
    public void name5() {
        List<AcLoan> acLoans = downLoad();
        for (AcLoan acLoan : acLoans) {
            System.out.println(acLoan);
        }
    }

    public List<AcLoan> downLoad(){
        ArrayList<AcLoan> acLoans = new ArrayList<>();
        try {
            File file = new File("D:/demo/demo.txt");
            if (file.exists()){
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader reader = new InputStreamReader(fileInputStream);
                BufferedReader bfReader = new BufferedReader(reader);
                String line = null;
                AcLoan acLoan;
                while ((line = bfReader.readLine()) != null){
                    String[] split = line.split("\\|\\+\\|");
                    System.out.println(split[0]);
                    acLoan = new AcLoan();
                    acLoan.setBatchNo(split[0]);
                    acLoan.setStatus(split[1]);
                    acLoan.setLoanDate(split[2]);
                    String loanAmount = split[3];

                    if (loanAmount != null){
                        acLoan.setLoanAmount(new BigDecimal(loanAmount));
                    }
                    acLoans.add(acLoan);
                }
                reader.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return acLoans;
    }
}


