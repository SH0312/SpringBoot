package com.sample.serviceImpl;

import java.util.List;

import com.sample.Fields.MongoField;
import com.sample.service.IMongodbService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class MongodbServiceImpl implements IMongodbService {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public List<MongoField> findAll() {
		return mongoTemplate.findAll(MongoField.class, "MongoTableName");
	}
}
