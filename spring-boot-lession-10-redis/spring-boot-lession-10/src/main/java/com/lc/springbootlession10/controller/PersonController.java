package com.lc.springbootlession10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lc.springbootlession10.entity.Person;
import com.lc.springbootlession10.repository.PersonRepository;

@RestController
@RequestMapping("/Person")
public class PersonController {

	@Autowired
	PersonRepository personRepository;
	
	@PostMapping("/save")	
	public boolean save(@RequestBody Person value){
		return personRepository.savePerson(value);
	}
	
	@GetMapping("/get")
	public Object get(@RequestParam String key){
		return personRepository.findPerson(key);
	}
	
}
