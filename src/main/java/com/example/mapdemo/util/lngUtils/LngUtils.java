package com.example.mapdemo.util.lngUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class LngUtils {
    /**
     * @param addr
     * 查询的地址
     * @return
     * @throws IOException
     */
    public static  Object[] getCoordinate(String addr) throws IOException {
        String lng = null;//经度
        String lat = null;//纬度
        //地理位置
        String address = null;
        try {
            //对地理位置信息字符串进行转码
            address = java.net.URLEncoder.encode(addr, "UTF-8");
        }catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        //百度api的key
        String key = "f247cdb592eb43ebac6ccd27f796e2d2";
        String url = String .format("http://api.map.baidu.com/geocoder?address=%s&output=json&key=%s", address, key);
        URL myURL = null;
        URLConnection httpsConn = null;
        try {
            myURL = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //输入流转换流
        InputStreamReader insr = null;
        //缓存字符流
        BufferedReader br = null;
        try {
            //打开链接
            httpsConn = (URLConnection) myURL.openConnection();// 不使用代理
            if (httpsConn != null) {
                //获取io链接
                insr = new InputStreamReader( httpsConn.getInputStream(), "UTF-8");
                br = new BufferedReader(insr);
                String data = null;
                int count = 1;
                while((data= br.readLine())!=null){
                    if(count==5){
                        lng = (String)data.subSequence(data.indexOf(":")+1, data.indexOf(","));//经度
                        count++;
                    }else if(count==6){
                        lat = data.substring(data.indexOf(":")+1);//纬度
                        count++;
                    }else{
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(insr!=null){
                insr.close();
            }
            if(br!=null){
                br.close();
            }
        }
        return new Object[]{lng,lat};
    }


    public static void main(String[] args) throws IOException {
        LngUtils getLatAndLngByBaidu = new LngUtils();
        Object[] o = getLatAndLngByBaidu.getCoordinate("湖北省襄阳市宜城市龚河村");
        System.out.println(o[0]);//经度
        System.out.println(o[1]);//纬度
        System.out.println("----------------------");
        // 经度
        String longitude = (String) o[0];
        // 维度
        String latitude = (String) o[1];
        System.out.println(longitude);
        System.out.println(latitude);
    }
}
