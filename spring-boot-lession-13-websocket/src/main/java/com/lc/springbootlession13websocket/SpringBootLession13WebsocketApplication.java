package com.lc.springbootlession13websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import com.lc.springbootlession13websocket.websocket.ChatRoomServerEndpoint;

@SpringBootApplication
public class SpringBootLession13WebsocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLession13WebsocketApplication.class, args);
	}
	
	/**
	 * 暴露Endpoint
	 * @return
	 */
	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}
	
	@Bean
	public ChatRoomServerEndpoint chatRoomServerEndpoint() {
		return new ChatRoomServerEndpoint();
	}
	
	
	
}
