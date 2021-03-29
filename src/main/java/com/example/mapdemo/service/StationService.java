package com.example.mapdemo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.mapdemo.entity.Station;
import com.example.mapdemo.mapper.StationMapper;
import com.example.mapdemo.util.jsonUtil.JsonParseUtil;
import com.example.mapdemo.util.mapUtil.MapUtil;
import com.example.mapdemo.util.mapUtil.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StationService {
    @Autowired
    StationMapper stationMapper;

    /**
     * 解析json文件获取地图信息
     * @return 地图信息
     */
    public Map<String,List<List<Point>>> getMapInfo() {
        String url = "F:\\projectSpace\\mapdemo\\src\\main\\resources\\jibei.json";
        JSONArray jsonArray = JsonParseUtil.readJsonFile(url);
        /**
         * [
         *   {
         *    "name":"秦皇岛市"，
         *    “data”:[
         *             [,],
         *             [,],
         *             .
         *             .
         *
         *
         *           ]
         *
         *   },
         * ]
         */
         //对json文件进行解析
        int size1 = jsonArray.size();
        Map<String,List<List<Point>>> map =new HashMap<>();
        for(int i = 0;i<size1;i++) {
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            //获取区县名称
            String name = jsonObject1.getString("name");
            //获取区县经纬度集合
            JSONArray jsonArray1 = jsonObject1.getJSONArray("data");
            //获取经纬度集合的长度
            int size2 = jsonArray1.size();
            //存储坐标点集合
            List<List<Point>> list1 = new ArrayList<>();
            for(int m = 0;m<size2;m++) {
                JSONArray jsonArray2 = jsonArray1.getJSONArray(m);
                int size3 = jsonArray2.size();
                //存储坐标点
                List<Point> list2 = new ArrayList<>();
                for(int n = 0;n<size3;n++) {
                    JSONArray jsonArray3 = jsonArray2.getJSONArray(n);
                    //获取经度
                    Double lng = jsonArray3.getDouble(0);
                    //获取纬度
                    Double lat =  jsonArray3.getDouble(1);
                    Point point = new Point(lng, lat);
                    list2.add(point);
                }
                list1.add(list2);

            }
            map.put(name,list1);

        }
        return map;
    }


    public void isExist(String cityName,List<List<Point>> pointList) {
        //查询一个地市的所属基础台账
        List<Station> stationList = stationMapper.getStationByScheduleName(cityName);
        List<Station> newList = new ArrayList<>();
        for(Station station:stationList) {
            Double lng = station.getLongitude();
            Double lat = station.getLatitude();
            Point point = new Point(lng, lat);
            boolean flag = false;
            for(List<Point> list:pointList) {
                flag = MapUtil.isPointInPolygon(point,list);
                if(flag) {
                    break;
                }
            }
            if(flag) {
                station.setLongitudeNew(lng);
                station.setLatitudeNew(lat);
                newList.add(station);
            } else {
                //调用百度api反推根据经纬度反推地理位置
            }
        }
        List<List<Station>> lists = splitList(newList,200);
        for(List<Station> stationList1 :lists) {
            stationMapper.batchUpdateLng(stationList1);

        }

    }



    public void execute() {
        //第一步获取地图信息
        Map<String, List<List<Point>>> mapInfo = this.getMapInfo();
        String[] cityArr = {"唐山","承德","张家口","廊坊","秦皇岛"};
        for(String cityName : cityArr) {
            //获取地市地图信息
            List<List<Point>> list =(List<List<Point>>)mapInfo.get(cityName);
            //获取地市电站信息
            this.isExist(cityName,list);
        }
    }

    /**
     * 将集合拆分成指定长度的子集合
     * @param stations 长集合
     * @param num 子集长度
     * @return 结果
     */
    public  List<List<Station>> splitList(List<Station>  stations,int num){
        List<List<Station>> result = new ArrayList<>();
        //长集合长度
         for(int i =0;i<stations.size();i++) {
             if(i%num == 0) {
                 List<Station> stations1 = stations.subList(i, i + num>stations.size()?stations.size(): i + num);
                 result.add(stations1);
             }
         }

        return result;
    }




}
