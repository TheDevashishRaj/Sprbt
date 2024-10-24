package com.diskord.diskord.model;

import java.io.Serializable;

public class ReceiverUser implements Serializable {
    private int messageId;
    private int receiverId;

    // Constructors
    public ReceiverUser() {}

    public ReceiverUser(int messageId, int receiverId) {
        this.messageId = messageId;
        this.receiverId = receiverId;
    }

    // Getters and Setters
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }
}