//package com.example.demo;
//
//import com.sophon.szc.service.struct.enums.TimeGranularity;
//
//import org.slf4j.Logger;
//
//import org.slf4j.LoggerFactory;
//
//import java.sql.Date;
//
//import java.text.SimpleDateFormat;
//
//import java.util.Calendar;
//
//import java.util.List;
//
///**
// * https://www.it610.com/article/1289895989880102912.htm
// * @return null
// * @Author chenqingdong
// * @Date 2021/5/21 19:14
// **/
//public class DateHelper {
//    private static Logger logger = LoggerFactory.getLogger(DateHelper.class);
//
//    public static String changeDate(String timeType ,String timeValue){
//        String dateString =null;
//
//        String[] arr = timeValue.split("-");
//
////根据传入参数和格式转换为日期
//
//        Date date;
//
//        if (timeType.equals(TimeGranularity.MONTH.toString())){
//            date = Date.valueOf(String.format("%s-%s-%s", arr[0], arr[1], 1));
//
//            dateString = date.toString();
//
//        }else if (timeType.equals(TimeGranularity.WEEK.toString())) {
//            Calendar cal = Calendar.getInstance();
//
//            cal.setFirstDayOfWeek(Calendar.MONDAY);
//
//            cal.set(Calendar.YEAR, Integer.valueOf(arr[0]));
//
//            cal.set(Calendar.WEEK_OF_YEAR, Integer.valueOf(arr[1]));
//
//            cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
//
//            date = Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
//
//            dateString =date.toString();
//
//        }
//
//        return dateString;
//
//    }
//
//    public static String transtlateDate(String timeType ,String timeValue){
//        String dateString =null;
//
//        StringBuilder dateToStringBuilder = new StringBuilder(timeValue);
//
//        dateToStringBuilder.insert(4,"-");
//
//        String dateToString = new String (dateToStringBuilder);
//
//        String[] arr = dateToString.split("-");
//
////根据传入参数和格式转换为日期
//
//        Date date;
//
//        if (timeType.equals(TimeGranularity.MONTH.toString())){
//            date = Date.valueOf(String.format("%s-%s-%s", arr[0], arr[1], 1));
//
//            dateString = date.toString();
//
//        }else if (timeType.equals(TimeGranularity.WEEK.toString())) {
//            Calendar cal = Calendar.getInstance();
//
//            cal.setFirstDayOfWeek(Calendar.MONDAY);
//
//            cal.set(Calendar.YEAR, Integer.valueOf(arr[0]));
//
//            cal.set(Calendar.WEEK_OF_YEAR, Integer.valueOf(arr[1]));
//
//            cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
//
//            date = Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
//
//            dateString =date.toString();
//
//        }
//
//        return dateString;
//
//    }
//
//}
//
