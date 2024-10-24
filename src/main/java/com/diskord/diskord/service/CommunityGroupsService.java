package com.diskord.diskord.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diskord.diskord.model.CommunityGroups;
import com.diskord.diskord.repository.CommunityGroupsRepository;

@Service
public class CommunityGroupsService {

    @Autowired
    private CommunityGroupsRepository communityGroupsRepository;

    // Add community-group relationship
    public void addCommunityGroup(CommunityGroups communityGroup) {
        communityGroupsRepository.addCommunityGroup(communityGroup);
    }

    // Remove community-group relationship
    public void removeCommunityGroup(int groupId, int communityId) {
        communityGroupsRepository.deleteCommunityGroup(groupId, communityId);
    }

    // Find groups by community
    public List<CommunityGroups> getGroupsByCommunityId(int communityId) {
        return communityGroupsRepository.findGroupsByCommunityId(communityId);
    }

    // Find communities by group
    public List<CommunityGroups> getCommunitiesByGroupId(int groupId) {
        return communityGroupsRepository.findCommunitiesByGroupId(groupId);
    }
}