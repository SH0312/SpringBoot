package com.sample.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sample.Fields.MysqlField;
import com.sample.service.IMysqlService;

@Service
public class MysqlServiceImpl implements IMysqlService{

    @Autowired
    @Qualifier("mysqlSessionTemplate")
    private SqlSession mysqlSqlSession;
    
	@Override
	public List<MysqlField> selectListTest() throws Exception {
		return mysqlSqlSession.selectList("com.sample.msyql.Mapper.selectListTest");
	}
	

}
