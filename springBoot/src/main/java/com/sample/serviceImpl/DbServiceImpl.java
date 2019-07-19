package com.sample.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.service.DbService;
 
 
@Service
public class DbServiceImpl {
 
    @Autowired
    DbService dbMapper;
 
    /* select dual */
    public String getDual() throws Exception{
        return dbMapper.getDual();
    }
 
}


