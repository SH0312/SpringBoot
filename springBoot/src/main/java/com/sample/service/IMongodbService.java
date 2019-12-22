package com.sample.service;

import java.util.List;

import com.sample.Fields.MongoField;

public interface IMongodbService{
	public List<MongoField> findAll();
}
