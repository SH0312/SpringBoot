package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sample.Fields.PostgresField;
import com.sample.serviceImpl.PostgresqlServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/postgres")
public class PostgresqlController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PostgresqlServiceImpl postgresqlService;

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public ModelAndView postgres() throws Exception {
		logger.info("postgres In");
		List<PostgresField> list = postgresqlService.selectListTest();

		for (PostgresField postgres : list) {
			logger.info(postgres.getId() + " - " + postgres.getName());
		}

		ModelAndView mv = new ModelAndView();
		mv.addObject("test", "index 페이지입니다.");
		mv.setViewName("index");
		return mv;
	}

}
