package org.acey.websocket.websocket;

import java.io.IOException;
import java.util.*;

import org.acey.websocket.entity.Group;
import org.acey.websocket.entity.Message;
import org.acey.websocket.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.google.gson.Gson;


@Component
public class MyWebSocketHandler implements WebSocketHandler {
    public static final Map<String, User> USER_AND_SESSION;
    public static final Map<String, Group> GROUP;

    static {
        USER_AND_SESSION = new HashMap<String, User>();
        GROUP = new HashMap<String, Group>();
    }

    /**
     * 建立连接后
     */
    public void afterConnectionEstablished(WebSocketSession session)
            throws Exception {
        User user = (User) session.getAttributes().get("user");
        if (USER_AND_SESSION.get(user.getId()) == null) {
            USER_AND_SESSION.put(user.getId(), user);
            user.setSession(session);
        }
    }

    /**
     * 消息处理
     */
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        if (message.getPayloadLength() == 0) return;
        final Map msg = new Gson().fromJson(message.getPayload().toString(), Map.class);
    }

    /**
     * 消息传输错误处理
     */
    public void handleTransportError(WebSocketSession session,
                                     Throwable exception) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
    }

    /**
     * 关闭连接后
     */
    public void afterConnectionClosed(WebSocketSession session,
                                      CloseStatus closeStatus) throws Exception {
    }

    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 给所有在线用户发送消息(除了自己）
     */
    public void sendGroupMember(final Message message, User user) throws Exception {
        for (final User userInfo : MyWebSocketHandler.USER_AND_SESSION.values()) {
            if (userInfo.getId().equals(user.getId())) continue;
            new Thread() {
                @Override
                public void run() {
                    try {
                        userInfo.getSession().sendMessage(new TextMessage(new Gson().toJson(message)));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    /**
     * 给某个用户发送消息
     */
    public void sendMessageToUser(String uid, TextMessage message)
            throws IOException {
        WebSocketSession session = USER_AND_SESSION.get(uid).getSession();
        if (session != null && session.isOpen()) {
            session.sendMessage(message);
        }
    }
}
