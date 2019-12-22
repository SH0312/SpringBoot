package com.sample.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sample.Fields.MysqlField;
import com.sample.Fields.Request;
import com.sample.serviceImpl.MysqlServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/mysql")
public class MysqlController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	MysqlServiceImpl mysqlService;

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public ModelAndView mysql() throws Exception {
		logger.info("mysql In");
		List<MysqlField> list = mysqlService.selectListTest();

		for (MysqlField mysql : list) {
			logger.info(mysql.getId() + " - " + mysql.getName() + " - " + mysql.getAge());
		}

		ModelAndView mv = new  ModelAndView();
		mv.addObject("test", "index 페이지입니다.");
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value = { "/insert"}, method = RequestMethod.GET)
	public ModelAndView mysqlInsert(Request request) throws Exception {
		logger.info(request.getName());
		logger.info("mysql In");
		MysqlField data = new  MysqlField();
		data.setName("테스트");
		data.setAge(46);
		data.setSex(2);
		
		int insert = mysqlService.insertTest(data);
		
		if(insert == 0)
			logger.info("insert 실패");
		else
			logger.info("insert 성공");
		
		ModelAndView mv = new  ModelAndView();
		mv.addObject("test", "index 페이지입니다.");
		mv.setViewName("index");
		return mv;
	}
	
}
