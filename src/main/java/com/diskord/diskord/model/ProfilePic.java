package com.diskord.diskord.model;

public class ProfilePic {
    private int fileId;
    private int userId;

    public ProfilePic(int fileId, int userId) {
        this.fileId = fileId;
        this.userId = userId;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}