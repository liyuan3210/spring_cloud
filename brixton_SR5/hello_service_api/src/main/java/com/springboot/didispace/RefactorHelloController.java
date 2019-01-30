package com.springboot.didispace;

import com.springboot.didispace.dto.User2;
import com.springboot.didispace.service.HelloService;

public class RefactorHelloController implements HelloService {

	@Override
	public String hello(String name) {
		return "Hello"+name;
	}

	@Override
	public User2 hello(String name, Integer age) {
		return new User2(name,age);
	}

	@Override
	public String hello(User2 user2) {
		return "Hello "+user2.getName()+", "+user2.getAge();
	}

}
