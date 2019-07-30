package com.sample.service;

import java.util.List;

import com.sample.Fields.PostgresField;

public interface IPostgresqlService {
	
	public List<PostgresField> selectListTest() throws Exception;
	
}
