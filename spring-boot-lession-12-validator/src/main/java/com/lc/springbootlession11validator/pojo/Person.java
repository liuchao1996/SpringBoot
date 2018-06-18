package com.lc.springbootlession11validator.pojo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Person {

	@NotNull
	private String name;
	
	@Min(0)
	@Max(value = 200, message = "人的年龄不能超过200")
	private int age;

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
