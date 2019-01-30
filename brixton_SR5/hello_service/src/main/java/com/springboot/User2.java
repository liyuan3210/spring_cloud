package com.springboot;

public class User2 {
	
	private String name;
	
	private Integer age;
	
	public User2(){
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public User2(String name,Integer age){
		this.name=name;
		this.age=age;
	}
	
	@Override
	public String toString(){
		return "name="+name+",age="+age;
	}
}
