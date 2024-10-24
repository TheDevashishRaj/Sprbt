package com.diskord.diskord.model;

public class ReceivedGroup {
    private int messageId;
    private int groupId;

    // Constructors
    public ReceivedGroup() {}

    public ReceivedGroup(int messageId, int groupId) {
        this.messageId = messageId;
        this.groupId = groupId;
    }

    // Getters and Setters
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}