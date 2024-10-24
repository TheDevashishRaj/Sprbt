package com.diskord.diskord.model;

public class Attachment {
    private int fileId;
    private int messageId;

    public Attachment(int fileId, int messageId) {
        this.fileId = fileId;
        this.messageId = messageId;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }
}