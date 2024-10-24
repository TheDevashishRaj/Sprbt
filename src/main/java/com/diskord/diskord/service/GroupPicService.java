package com.diskord.diskord.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.diskord.diskord.model.GroupPic;
import com.diskord.diskord.repository.GroupPicRepository;

@Service
public class GroupPicService {
    private final GroupPicRepository groupPicRepository;

    public GroupPicService(GroupPicRepository groupPicRepository) {
        this.groupPicRepository = groupPicRepository;
    }

    public void addGroupPic(GroupPic groupPic) {
        groupPicRepository.save(groupPic);
    }

    public void removeGroupPic(int fileId, int groupId) {
        groupPicRepository.delete(fileId, groupId);
    }

    public List<GroupPic> getGroupPicsByGroupId(int groupId) {
        return groupPicRepository.findByGroupId(groupId);
    }

    public List<GroupPic> getGroupPicsByFileId(int fileId) {
        return groupPicRepository.findByFileId(fileId);
    }
}
