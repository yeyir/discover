package com.chan.discover.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chan.discover.dto.Duck;

@RestController
public class Helloworld {
    @RequestMapping(path = "hello")
    public String hello(){
        Duck duck = new Duck();
        duck.setColor("color");
        duck.setWeight("weight");
        Map<String,String> testMap =  new HashMap<String,String>();
        testMap.put("A", "S");
        return "you create a duck"+duck.toString();
    }
}
