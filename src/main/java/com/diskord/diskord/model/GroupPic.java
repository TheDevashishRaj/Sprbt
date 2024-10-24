package com.diskord.diskord.model;

public class GroupPic {
    private int fileId;
    private int groupId;

    public GroupPic(int fileId, int groupId) {
        this.fileId = fileId;
        this.groupId = groupId;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}