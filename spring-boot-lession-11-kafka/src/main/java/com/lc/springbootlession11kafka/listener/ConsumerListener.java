package com.lc.springbootlession11kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.lc.springbootlession11kafka.pojo.User;

/**
 * 消费者监听器
 * 
 * @author qq165
 *
 */
@Component
public class ConsumerListener {

	// 设置监听主题
	@KafkaListener(topics = "lc")
	public void consumer(String message) {
		System.out.println("消费者监听器：" + message);
	}

	@KafkaListener(topics = "user")
	public void consumer(User user) {

		System.err.println(user);

	}
}
