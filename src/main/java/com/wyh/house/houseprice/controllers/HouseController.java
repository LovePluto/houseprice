package com.wyh.house.houseprice.controllers;


import com.wyh.house.houseprice.po.House;
import com.wyh.house.houseprice.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class HouseController extends BaseController {
    @Autowired
    private HouseService houseService;

//    @GetMapping("/getAll")
//    public List<House> getAll() {
//        return houseService.getAll();
//    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<House> getAll() {
        List<House> all = houseService.getAll();
//        List<Double>
        return houseService.getAll();
    }

    @RequestMapping("/index")
    public String toIndex() {
        return "index";
    }

    @GetMapping("/getPriceArea")
    @ResponseBody
    public Map<String, List> getPriceArea() {
        List<House> all = houseService.getAll();
        Collections.sort(all, (o1, o2) -> new Double(o1.getSize() - o2.getSize()).intValue());
        Map<String, List> map = new HashMap<>();
        List<Double> totalList = new ArrayList<>();
        List<Double> sizeList = new ArrayList<>();
        List<Integer> areaList = new ArrayList<>();
        int count = 1;
        for (House house : all) {
            totalList.add(house.getTotalPrice());
            sizeList.add(house.getSize());
            areaList.add(house.getAreaPrice());
//            if (count > 100) {
//                break;
//
//            } else {
//                count++;
//            }
        }
        map.put("size", sizeList);
        map.put("total", totalList);
        map.put("area",areaList);
        return map;
    }
}
