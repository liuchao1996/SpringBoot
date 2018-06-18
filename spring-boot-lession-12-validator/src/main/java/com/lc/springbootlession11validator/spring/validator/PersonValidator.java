package com.lc.springbootlession11validator.spring.validator;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.lc.springbootlession11validator.pojo.Person;

public class PersonValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		//Person类和Person得实现类都可以匹配上
		return Person.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Person person = Person.class.cast(target);
		
		String name = person.getName();
		
		if(!StringUtils.hasLength(name)) {
			//拒绝
			errors.reject("Person.name.not.null", "人的名字不能为空");
			
		}
	}

}
