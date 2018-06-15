package com.lc.springbootlession10;
import java.util.Collections;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfiguration {

	@Bean
	public CacheManager simpleCacheManager() {
		SimpleCacheManager cacheManager = new SimpleCacheManager();
		
		ConcurrentMapCache cache = new ConcurrentMapCache("cache-1");
		
		cacheManager.setCaches(Collections.singleton(cache));
		
		return cacheManager;
	}
	
}
