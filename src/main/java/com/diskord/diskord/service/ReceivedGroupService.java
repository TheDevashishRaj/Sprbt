package com.diskord.diskord.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.diskord.diskord.model.ReceivedGroup;
import com.diskord.diskord.repository.ReceivedGroupRepository;

@Service
public class ReceivedGroupService {

    private final ReceivedGroupRepository repository;

    public ReceivedGroupService(ReceivedGroupRepository repository) {
        this.repository = repository;
    }

    // Save received group
    public void saveReceivedGroup(ReceivedGroup receivedGroup) {
        repository.save(receivedGroup);
    }

    // Get received groups by message ID
    public List<ReceivedGroup> getReceivedGroupsByMessageId(int messageId) {
        return repository.findByMessageId(messageId);
    }

    // Get all received groups
    public List<ReceivedGroup> getAllReceivedGroups() {
        return repository.findAll();
    }

    // Delete a received group
    public void deleteReceivedGroup(int messageId, int groupId) {
        repository.delete(messageId, groupId);
    }
}
