package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sample.Fields.MysqlField;
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

		ModelAndView mv = new ModelAndView();
		mv.addObject("test", "index 페이지입니다.");
		mv.setViewName("index");
		return mv;
	}
}
