package com.sample.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelAndViewTestController {

	@RequestMapping(value = "/mv") // http://localhost/mv
	public ModelAndView root() {
		
		System.out.println("aaaaaaa");
		ModelAndView mv = new ModelAndView();

		List<String> listTest = new ArrayList<String>();

		listTest.add("test1");
		listTest.add("test2");
		listTest.add("test3");

		mv.addObject("listTest", listTest); // jstl로 호출
		mv.addObject("ObjectTest", "테스트입니다."); // jstl로 호출
		mv.setViewName("testMv"); // 실제 호출될 /WEB-INF/jsp/model/testMv.jsp
		return mv;
	}
}
