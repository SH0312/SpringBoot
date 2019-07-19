package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dao.DbMapper;
 
 
@Service
public class DbService {
 
    @Autowired
    DbMapper dbMapper;
 
    /* select dual */
    public String getDual() throws Exception{
        return dbMapper.getDual();
    }
 
}


