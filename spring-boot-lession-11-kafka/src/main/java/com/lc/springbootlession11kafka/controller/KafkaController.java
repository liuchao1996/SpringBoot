package com.lc.springbootlession11kafka.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lc.springbootlession11kafka.pojo.User;

/**
 * kafka控制器
 * @author qq165
 *
 */
@RestController
public class KafkaController {

	@Autowired
	private  KafkaTemplate<String, Object> kafkaTemplate;
	

	@GetMapping("/message/send")
	public String sendMessage(@RequestParam String message) throws UnsupportedEncodingException {
		kafkaTemplate.send("lc",0,message);
		return message;
	}
	
	@PostMapping("/user/save")
	public User saveUser(@RequestBody User user) {
        kafkaTemplate.send("user", 0, user);		
        return user;
	}
}
