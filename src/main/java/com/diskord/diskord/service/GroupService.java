package com.diskord.diskord.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import com.diskord.diskord.model.Group;
import com.diskord.diskord.repository.GroupRepository;

@Service
public class GroupService {
    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public void createGroup(Group group) {
        System.out.println("Received Group: " + group);
        group.setCreationDate(new Timestamp(System.currentTimeMillis())); // Set creation date to current time
        groupRepository.save(group);
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Group getGroupById(int groupId) {
        return groupRepository.findById(groupId);
    }

    public void updateGroup(Group group) {
        groupRepository.update(group);
    }

    public void deleteGroup(int groupId) {
        groupRepository.delete(groupId);
    }
}