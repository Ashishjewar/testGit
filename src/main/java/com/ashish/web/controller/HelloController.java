package com.ashish.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)  
    public String home() {  
	 System.out.println("inside SpringController");
        return "hello";  
    }  
      
    @RequestMapping(value="/admin", method=RequestMethod.GET)  
    public String privateHome() {  
    	System.out.println("inside private page");
        return "admin";  
    } 

}
