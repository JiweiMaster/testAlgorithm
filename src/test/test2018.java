package test;

import util.GsonUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class test2018 {

    static int MAX_SIZE = 10;
    //弹出对应的数据
    public static void main(String[] args){
        String str = "2x+4-3x=x-2";
        List<String> leftX = new ArrayList<String>();
        List<String> leftN = new ArrayList<String>();
        List<String> rightX = new ArrayList<String>();
        List<String> rightN = new ArrayList<String>();

        int preX = 0;
        int preConstant = 0;

        String[] expressArray = str.split("=");
        String temp = "";
        //转移左边的数据**************************************************************************************
        for(int i=0;i<expressArray[0].length();i++){
            String curChar = String.valueOf(expressArray[0].charAt(i));
            if(!isSign(curChar)){//不是符号
                temp = temp+expressArray[0].charAt(i);
            }else{
                if(temp.contains("x")){
                    if(temp.equals("x")){
                        leftX.add("1");
                    }else{
                        leftX.add(temp.replace("x",""));
                    }
                }else{
                    leftN.add(temp);
                }
                temp = "";
                if(curChar.equals("-")){
                    temp = "-";
                }
            }
        }
        //加入最后一个字符
        if(temp.contains("x")){
            if(temp.equals("x")){
                leftX.add("1");
            }else{
                leftX.add(temp.replace("x",""));
            }
        }else{
            leftN.add(temp);
        }
        temp = "";
        //处理右边的数据**************************************************************************************
        for(int i=0;i<expressArray[1].length();i++){
            String curChar = String.valueOf(expressArray[1].charAt(i));
            if(!isSign(curChar)){//不是符号
                temp = temp+expressArray[1].charAt(i);
            }else{
                if(temp.contains("x")){
                    if(temp.equals("x")){
                        rightX.add("1");
                    }else{
                        rightX.add(temp.replace("x",""));
                    }
                }else{
                    rightN.add(temp);
                }
                temp = "";
                if(curChar.equals("-")){
                    temp = "-";
                }
            }
        }
        //加入最后一个字符
        if(temp.contains("x")){
            if(temp.equals("x")){
                rightX.add("1");
            }else{
                rightX.add(temp.replace("x",""));
            }
        }else{
            rightN.add(temp);
        }
        temp = "";
        //****************************************计算所有的值*******************************************************
        for(String s : leftX){
            preX = preX+Integer.parseInt(s);
        }
        for(String s : rightX){
            preX = preX-Integer.parseInt(s);
        }

        for(String s : leftN){
            preConstant = preConstant + Integer.parseInt(s);
        }
        for(String s : rightN){
            preConstant = preConstant - Integer.parseInt(s);
        }


        System.out.println(GsonUtil.ObjectToJson(preX));
        System.out.println(GsonUtil.ObjectToJson(-preConstant));
//
        System.out.println(GsonUtil.ObjectToJson(leftX));
        System.out.println(GsonUtil.ObjectToJson(leftN));
        System.out.println(GsonUtil.ObjectToJson(rightX));
        System.out.println(GsonUtil.ObjectToJson(rightN));

        System.out.println("result=>"+(-preConstant)/preX);
    }



    //
    public static boolean isSign(String i){
        String[] sign = {"+","-"};
        for(String c : sign){
            if(c.equals(i)){
                return true;
            }
        }
        return false;
    }
}
