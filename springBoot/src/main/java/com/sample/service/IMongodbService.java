package com.sample.service;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.sample.Fields.MongoField;


public interface IMongodbService extends MongoRepository<MongoField, Long> {
}
