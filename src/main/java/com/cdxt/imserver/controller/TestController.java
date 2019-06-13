package com.cdxt.imserver.controller;

import com.cdxt.imserver.config.HuanXinProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    HuanXinProperties properties;
    @GetMapping("test")
    public String testConfig(){
        ObjectMapper objectMapper = new ObjectMapper();
        String s = null;
        try {
            s = objectMapper.writeValueAsString(properties);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return s;
    }
}
