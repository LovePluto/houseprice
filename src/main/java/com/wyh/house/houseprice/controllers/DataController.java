package com.wyh.house.houseprice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {


    @GetMapping("/lianjiaTo")
    public String lianjiaToTotal() {

        return "OK";
    }
}
