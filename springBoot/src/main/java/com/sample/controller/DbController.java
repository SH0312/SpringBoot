package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.service.DbService;
 
 
@RestController
public class DbController {
    @Autowired
    DbService dbService;
     
    @RequestMapping("/now")
    public @ResponseBody String now() throws Exception{
        return dbService.getDual();
    }
}


