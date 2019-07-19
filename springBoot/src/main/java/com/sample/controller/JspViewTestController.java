package com.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class JspViewTestController {
     
    @RequestMapping(value="/")      // localhost
    public String root() {
    	System.out.println("a");
        return "viewtest.jsp";          // 실제 호출될 /WEB-INF/jsp/viewtest.jsp       
    }
     
    @RequestMapping(value="/test")  // localhost/test
    public String test() {
    	System.out.println("b");
        return "WEB-INF/jsp/test/test2.jsp";        // 실제 호출될 /WEB-INF/jsp/test/viewtest2.jsp       
    }
 
}

