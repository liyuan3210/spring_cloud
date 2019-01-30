package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloController {
	@Autowired
	private Sender sender;
	
	@ResponseBody
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello(){
		sender.send();
		return "Hello World";
	}
}
