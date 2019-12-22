package com.sample.service;

import java.util.List;

import com.sample.Fields.MysqlField;;

public interface IMysqlService {
	public List<MysqlField> selectListTest() throws Exception;
	
	public int insertTest(MysqlField data) throws Exception;
}


