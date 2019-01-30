package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Autowired
	private Book book;
	
	@RequestMapping("/hello")
	public String hello(){
		System.out.println("###action name:"+book.getName()+" ###author:"+book.getAuthor());
		return "hello world";
	}
}
