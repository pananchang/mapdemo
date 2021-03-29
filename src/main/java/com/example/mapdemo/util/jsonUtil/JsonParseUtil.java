package com.example.mapdemo.util.jsonUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.math.BigDecimal;

public class JsonParseUtil {

    //读取json文件
    public static JSONArray readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            JSONArray jobj = JSON.parseArray(jsonStr);
            return jobj;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String data="[{\"data\":[[1,2],[,2,3]]}]";
        JSONArray objects = JSON.parseArray(data);
        JSONObject jsonObject = objects.getJSONObject(0);
        JSONArray data1 = jsonObject.getJSONArray("data");
        JSONArray jsonArray = data1.getJSONArray(0);
        BigDecimal bigDecimal = jsonArray.getBigDecimal(0);
        System.out.println(bigDecimal);

    }
}
