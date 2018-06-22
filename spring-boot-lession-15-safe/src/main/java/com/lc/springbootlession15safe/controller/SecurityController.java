package com.lc.springbootlession15safe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 安全Controller
 * @author qq165
 *
 */ 
@Controller
public class SecurityController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/xss")
	public String xss(Model model) {
		model.addAttribute("jsCode", "<script>alert('xss attak')</script>");
		return "xss";
	}
}
