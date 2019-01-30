package com.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello(){
		Book book=new Book();
		System.out.println("###action name:"+book.getName()+" ###author:"+book.getAuthor());
		return "hello world";
	}
}
