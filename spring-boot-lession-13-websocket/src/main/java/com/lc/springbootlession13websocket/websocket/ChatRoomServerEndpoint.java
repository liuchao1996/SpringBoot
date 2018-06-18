package com.lc.springbootlession13websocket.websocket;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

//端点
@ServerEndpoint("/chat-room/{username}")
public class ChatRoomServerEndpoint {

	private static Map<String, Session> livingSession = new ConcurrentHashMap<String, Session>();
	
	// 打开连接
	@OnOpen
	public void openSession(@PathParam("username") String username, Session session) {
		String sessionId = session.getId();
		livingSession.put(sessionId, session);
		sendTextAll("欢迎用户[" + username + "] 来到聊天室");
	}
	
	/**
	 * 收到客户端消息后调用的方法
	 * @param username
	 * @param session
	 * @param message
	 */
	@OnMessage
	public void onMessage(@PathParam("username") String username, Session session, String message) {
		
		//sendText(session, "用户[" + username + "] ：" + message);
		sendTextAll("用户[" + username + "] ：" + message);
	}
	
	
	private void sendTextAll(String message) {
		livingSession.forEach((sessionId, session) ->{
			sendText(session, message);
		});
	}
	
	/**
	 * 连接关闭调用的方法
	 * @param username
	 * @param session
	 */
	@OnClose
	public void onClose(@PathParam("username") String username, Session session) {
		String sessionId = session.getId();
		//当前session移除
		livingSession.remove(sessionId);
		//并且通知其他人当前用户已经离开了聊天室
		sendTextAll("用户[" + username + "] 已经离开聊天室了");
	}

	/**
	 * 发送消息
	 * @param session
	 * @param message
	 */
	public void sendText(Session session, String message) {
		
		// 获得客户端传过来的Remote
		RemoteEndpoint.Basic basic = session.getBasicRemote();
		
		try {
			//发送消息
			basic.sendText(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
