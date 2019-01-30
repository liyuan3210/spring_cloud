package com.springboot;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * 服务提供者2
 * @author liyuan
 *
 */
@RestController
public class HelloController2 {
	@RequestMapping(value="/hello1",method=RequestMethod.GET)
	public String hello(@RequestParam String name){
		return "Hello"+name;
	}
	
	@RequestMapping(value="/hello2",method=RequestMethod.GET)
	public User2 hello2(@RequestHeader String name,@RequestHeader Integer age){
		return new User2(name,age);
	}
	
	@RequestMapping(value="/hello3",method=RequestMethod.POST)
	public String hello3(@RequestBody User2 user2){
		return "Hello "+user2.getName()+", "+user2.getAge();
	}
	
}
