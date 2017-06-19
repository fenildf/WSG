package org.acey.websocket.entity;

public class Group {
    private String id;
    private String groupId;
    private String firstUserId;
    private String firstUserName;
    private String lastUserId;
    private String lastUserName;

    public Group() {
    }

    public Group(String id, User firstUser) {
        this.id = id;
        this.groupId = firstUser.getGroupId();
        this.firstUserId = firstUser.getId();
        this.firstUserName = firstUser.getName();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getFirstUserName() {
        return firstUserName;
    }

    public void setFirstUserName(String firstUserName) {
        this.firstUserName = firstUserName;
    }

    public String getLastUserName() {
        return lastUserName;
    }

    public void setLastUserName(String lastUserName) {
        this.lastUserName = lastUserName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstUserId() {
        return firstUserId;
    }

    public void setFirstUserId(String firstUserId) {
        this.firstUserId = firstUserId;
    }

    public String getLastUserId() {
        return lastUserId;
    }

    public void setLastUserId(String lastUserId) {
        this.lastUserId = lastUserId;
    }

    public void setLastUser(User lastUser) {
        this.lastUserId = lastUser.getId();
        this.lastUserName = lastUser.getName();
    }
}
