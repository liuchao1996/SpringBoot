package com.lc.springbootlession10.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lc.springbootlession10.entity.Person;

@RestController
@RequestMapping("/cache")
public class CacheController {

	@Autowired
	private CacheManager cacheManager;
	
	@PostMapping("/save")	
	public Map<String,Object> save(@RequestParam String key, @RequestBody Person value){
		Cache cache = cacheManager.getCache("cache-1");
		cache.put(key, value);
		Map<String,Object> result = new HashMap<>();
		result.put(key, value);
		return result;
	}
	
	@GetMapping("/get")
	public Object get(@RequestParam String key){
		Cache cache = cacheManager.getCache("cache-1");
		ValueWrapper vw =  cache.get(key);
		if(vw == null) {
			return "没有查询到数据！";
		}
		return vw.get();
	}
}
