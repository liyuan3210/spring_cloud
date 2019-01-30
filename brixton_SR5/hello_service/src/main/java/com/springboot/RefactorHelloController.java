package com.springboot;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import com.springboot.didispace.dto.User2;
//import com.springboot.didispace.service.HelloService;
//
//@RestController
//public class RefactorHelloController implements HelloService {
//	
//	@Override
//	public String hello(@RequestParam("name") String name){
//		return "Hello"+name;
//	}
//	
//	@Override
//	public User2 hello(@RequestHeader("name") String name,@RequestHeader("age") Integer age){
//		return new User2(name,age);
//	}
//	
//	@Override
//	public String hello(@RequestBody User2 user2){
//		return "Hello "+user2.getName()+", "+user2.getAge();
//	}
//
//}
