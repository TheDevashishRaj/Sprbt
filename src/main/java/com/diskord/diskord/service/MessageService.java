package com.diskord.diskord.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.diskord.diskord.model.Message;
import com.diskord.diskord.repository.MessageRepository;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public int saveMessage(Message message) {
        return messageRepository.save(message);
    }

    public Message findMessageById(int messageId) {
        return messageRepository.findById(messageId);
    }

    public List<Message> findAllMessages() {
        return messageRepository.findAll();
    }

    public int updateMessage(Message message) {
        return messageRepository.update(message);
    }

    public int deleteMessage(int messageId) {
        return messageRepository.deleteById(messageId);
    }
}
