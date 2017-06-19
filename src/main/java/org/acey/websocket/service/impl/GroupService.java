package org.acey.websocket.service.impl;

import org.acey.websocket.entity.Group;
import org.acey.websocket.entity.User;
import org.acey.websocket.service.IGroupService;
import org.acey.websocket.websocket.MyWebSocketHandler;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GroupService implements IGroupService {

    public Group create(User user) throws Exception {
        String groupId = UUID.randomUUID().toString();
        user.setGroupId(groupId);

        return new Group(groupId, user);
    }

    public String delete(User user) throws Exception {
        String groupId = user.getGroupId();
        MyWebSocketHandler.GROUP.remove(user.getGroupId());
        user.setGroupId(null);

        return groupId;
    }

    public void join(User user, String groupId) throws Exception {

    }

    public void leave(User user) throws Exception {

    }
}
