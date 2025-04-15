package com.sist.manager;
import java.util.*;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.sist.vo.*;
@ServerEndpoint(value="/site/chat/chat-ws", configurator = WebSocketSessionConfigurator.class)
public class ChatServer {
	private static Map<Session,MemberVO> users;
	@OnOpen
	public void onOpen(Session session,EndPon)