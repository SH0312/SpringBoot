package com.sample.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sample.Fields.PostgresField;
import com.sample.service.IPostgresqlService;

@Service
public class PostgresqlServiceImpl implements IPostgresqlService{

    @Autowired
    @Qualifier("postgreSqlSessionTemplate")
    private SqlSession postgresqlSqlSession;
    
	@Override
	public List<PostgresField> selectListTest() throws Exception {
		return postgresqlSqlSession.selectList("com.sample.postgres.Mapper.selectListTest");
	}
	

}
