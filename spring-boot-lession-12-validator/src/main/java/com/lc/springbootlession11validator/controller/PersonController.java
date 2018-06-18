package com.lc.springbootlession11validator.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lc.springbootlession11validator.pojo.Person;

@RestController
public class PersonController {

	@PostMapping("/person/save")
	public Person save(@Valid @RequestBody Person person) {
		
		return person;
	}
	
	@GetMapping("/message/send")
	@Validated
	public String validator(@NotNull @RequestParam String key) {
	   	return key;
	}
	
}
