package org.acey.websocket.entity;

import org.springframework.web.socket.WebSocketSession;

public class User {
	private String id;
	private String name;
	private String groupId;
	private WebSocketSession session;


	public User() {
	}

	public User(String id, String name, String groupId, WebSocketSession session) {
		this.id = id;
		this.name = name;
		this.groupId = groupId;
		this.session = session;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public WebSocketSession getSession() {
		return session;
	}

	public void setSession(WebSocketSession session) {
		this.session = session;
	}
}
