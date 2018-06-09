package com.lc.springbootlession7.controller;

import javax.websocket.server.PathParam;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lc.springbootlession7.model2.Person;

@RestController
public class MyBatisController {

	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	@RequestMapping("/getUser/{id}")
	public Person getPerson(@PathVariable int id) {
		
		Person person = sessionTemplate.selectOne("com.lc.springbootlession7.dao.PersonMapper.selectByPrimaryKey", id);
		return person;
	}
}
