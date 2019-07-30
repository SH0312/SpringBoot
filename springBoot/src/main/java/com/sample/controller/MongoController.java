package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.json.simple.parser.ParseException;

import com.sample.Fields.MongoField;
import com.sample.serviceImpl.MongodbServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/mongo")
public class MongoController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	MongodbServiceImpl mongoService;
	
	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public ModelAndView mongo() throws ParseException {
		logger.info("Mongo In");
		List<MongoField> list = mongoService.findAll();
		
		for(MongoField mongo : list) {
			logger.info(mongo.getClassification() + " - " + mongo.getNews());
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("test", "index 페이지입니다.");
		mv.setViewName("index");
		return mv;
	}
}
