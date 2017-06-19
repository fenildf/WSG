package org.acey.websocket.service;

import org.acey.websocket.entity.Group;
import org.acey.websocket.entity.User;

public interface IGroupService {

    Group create(User user) throws Exception;

    String delete(User user) throws Exception;

    void join(User user, String groupId) throws Exception;

    void leave(User user) throws Exception;
}
