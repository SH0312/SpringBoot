package com.sample;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class PostgresqlConfig {
	@Bean(name = "postgresqlDataSource")
	@ConfigurationProperties(prefix = "spring.db2.datasource")
	public DataSource postgresqlDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "postgresqlSessionFactory")
	public SqlSessionFactory postgresqlSessionFactory(
			@Autowired @Qualifier("postgresqlDataSource") DataSource dataSource) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sessionFactory.setMapperLocations(resolver.getResources("classpath:sqlmap/postgresql/*.xml"));

		return sessionFactory.getObject();
	}

	@Bean(name = "postgreSqlSessionTemplate")
	public SqlSessionTemplate postgreSqlSessionTemplate(
			@Autowired @Qualifier("postgresqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	@Bean(name = "postgresqlTransactionManager")
	public DataSourceTransactionManager secondaryTransactionManager(
			@Autowired @Qualifier("postgresqlDataSource") DataSource secondaryDataSource) {
		return new DataSourceTransactionManager(secondaryDataSource);
	}
}