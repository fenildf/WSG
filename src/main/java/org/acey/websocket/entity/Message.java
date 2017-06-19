package org.acey.websocket.entity;

public class Message<T>{
    private String operation;
    private T data;

    public Message(String operation) {
        this.operation = operation;
    }

    public Message(String operation, T data) {
        this.operation = operation;
        this.data = data;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
