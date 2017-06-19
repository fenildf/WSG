package org.acey.websocket.entity;

public class GroupMessage {
    private String operation;
    private String groupId;
    private User user;

    public GroupMessage(String add, Long id, User user) {
    }

    public GroupMessage(String operation, String groupId,User user) {
        this.groupId = groupId;
        this.operation = operation;
        this.user = user;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
