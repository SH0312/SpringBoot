package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.serviceImpl.DbServiceImpl;
 
 
@RestController
public class MysqlController {
    @Autowired
    DbServiceImpl dbService;
     
    @RequestMapping("/mysql")
    public @ResponseBody String now() throws Exception{
        return dbService.getDual();
    }
}
