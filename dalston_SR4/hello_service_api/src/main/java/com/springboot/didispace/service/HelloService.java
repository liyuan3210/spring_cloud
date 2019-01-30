package com.springboot.didispace.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.didispace.dto.User2;

@RequestMapping("/refactor")
public interface HelloService {
	
	
	@RequestMapping(value="/hello4",method=RequestMethod.GET)
	String hello(@RequestParam("name") String name);
	
	@RequestMapping(value="/hello5",method=RequestMethod.GET)
	User2 hello(@RequestHeader("name") String name,@RequestHeader("age") Integer age);

	@RequestMapping(value="/hello6",method=RequestMethod.POST)
	String hello(@RequestBody User2 user2);
	
}
