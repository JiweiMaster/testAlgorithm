package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test2019 {


    public static void  main(String[] args){
        System.out.println("test");
        System.out.println(calculate("20200504","20200501"));;
    }


    public static int calculate(String date1,String data2){
        try{
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            Date d1 = format.parse(date1);
            Date d2 = format.parse(data2);
            int dis = (int) ((d1.getTime()-d2.getTime())/1000/3600/24);
            return dis;
        }catch (Exception e){
           return -1;
        }
    }
}
