package com.yuanian.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

public class GetUrl {
    public String result() {
        //接口地址
        String requestUrl = "http://192.168.51.69:8080/getdata";


        //params用于存储要请求的参数
        Map params = new HashMap();

        Calendar c=new GregorianCalendar();
        c.setTime(new Date());
        c.add(c.DATE,-1);
        Date date=c.getTime();
        String startTime=new java.sql.Date(date.getTime()).toString();
        String lastTime=new java.sql.Date(new Date().getTime()).toString() ;
        //util.date转sql.date
        //       java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        //       System.out.println(sqlDate);   //2019-08-29

        params.put("startTime",startTime);
        params.put("lastTime",lastTime);

        //调用httpRequest方法，这个方法主要用于请求地址，并加上请求参数
        String string = httpRequest(requestUrl, params);
        //System.out.println(string);
        return string;
    }

    public String httpRequest(String requestUrl, Map params) {
        //buffer用于接受返回的字符
        StringBuffer buffer = new StringBuffer();
        try {
            //建立URL，把请求地址给补全，其中urlencode（）方法用于把params里的参数给取出来
            URL url = new URL(requestUrl + "?" + urlencode(params));
            //打开http连接
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestMethod("POST");
            httpUrlConn.connect();

            //获得输入
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            //将bufferReader的值给放到buffer里
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            //关闭bufferReader和输入流
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            //断开连接
            httpUrlConn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回字符串
        return buffer.toString();
    }

    public static String urlencode(Map<String, Object> data) {
        //将map里的参数变成像 showapi_appid=###&showapi_sign=###&的样子
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
