package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import util.GsonUtil;

public class test2017 {
    //1、证书序列求中位数
    public static void main(String[] args) throws  Exception{
//        middle();
        String dataStr = "2-02-033598";
        dataStr = dataStr.replace("-","");
        int[] array = new int[9];
        for(int i=0;i<9;i++){
            array[i] = Integer.parseInt(String.valueOf(dataStr.charAt(i)));
        }
        int[] M = new int[9];
        int[] multiple = {10,9,8,7,6,5,4,3,2};
        String result = "";
        for(int i=0;i<9;i++){
            M[i] = 11-(array[i]*multiple[i])%11;
            if(M[i]>=1 && M[i] <= 9){
                result = result+M[i];
            }
            if(M[i] == 11){
                result = result +"0";
            }
            if(M[i] == 10){
                result = result +"X";
            }
            if(i == 0 || i==2){
                result = result +"-";
            }
        }
        System.out.println(result);
    }


    public static void middle(){
        String[] arrayStr = {"3","6","-1","2","9","4","0","5"};
        Integer[] array = new Integer[arrayStr.length];
        for(int i=0;i<arrayStr.length;i++){
            array[i] = Integer.parseInt(arrayStr[i]);
        }
        List<Integer> list = new ArrayList<Integer>();
        list.addAll(Arrays.asList(array));
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        System.out.println(GsonUtil.ObjectToJson(list));
    }


}
