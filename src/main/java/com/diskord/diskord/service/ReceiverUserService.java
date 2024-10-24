package com.diskord.diskord.service;

import org.springframework.stereotype.Service;

import com.diskord.diskord.model.ReceiverUser;
import com.diskord.diskord.repository.List;
import com.diskord.diskord.repository.ReceiverUserRepository;

@Service
public class ReceiverUserService {
    private final ReceiverUserRepository receiverUserRepository;

    public ReceiverUserService(ReceiverUserRepository receiverUserRepository) {
        this.receiverUserRepository = receiverUserRepository;
    }

    // Method to save receiver_user
    public void saveReceiverUser(ReceiverUser receiverUser) {
        receiverUserRepository.save(receiverUser);
    }

    // Method to delete receiver_user
    public void deleteReceiverUser(int messageId, int receiverId) {
        receiverUserRepository.delete(messageId, receiverId);
    }

    // Method to get receivers by message_id
    public List<ReceiverUser> getReceiversByMessageId(int messageId) {
        return receiverUserRepository.findByMessageId(messageId);
    }
}
