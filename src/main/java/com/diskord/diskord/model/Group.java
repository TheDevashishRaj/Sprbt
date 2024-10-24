package com.diskord.diskord.model;

import java.sql.Timestamp;

public class Group {
    private int groupId;
    private String groupName;
    private String inviteLink;
    private String groupDescription;
    private Timestamp creationDate;

    // Getters and Setters

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getInviteLink() {
        return inviteLink;
    }

    public void setInviteLink(String inviteLink) {
        this.inviteLink = inviteLink;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Group [groupId=" + groupId + ", groupName=" + groupName + ", inviteLink=" + inviteLink
                + ", groupDescription=" + groupDescription + ", creationDate=" + creationDate + "]";
    }
}

