package com.diskord.diskord.model;

public class CommunityGroups {

    private int groupId;
    private int communityId;

    // Constructors
    public CommunityGroups() {}

    public CommunityGroups(int groupId, int communityId) {
        this.groupId = groupId;
        this.communityId = communityId;
    }

    // Getters and Setters
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }
}