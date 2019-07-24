package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.service.MysqlService;
import com.sample.vo.MemberVO;

@RestController
public class MysqlController {
	@Autowired
	MysqlService dbService;

	@RequestMapping("/mysql")
	public @ResponseBody String now() throws Exception {
		List<MemberVO> list = dbService.selectMemberList();

		for (MemberVO vo : list) {
			System.out.println(vo.getId() + " - " + vo.getName() + " - " + vo.getAge());
		}
		if (list.size() != 0)
			return "success";
		else
			return "fail";

	}
}
