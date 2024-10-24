package com.diskord.diskord.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diskord.diskord.model.Reply;
import com.diskord.diskord.repository.ReplyRepository;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    public void addReply(Reply reply) {
        replyRepository.addReply(reply);
    }

    public void removeReply(int replyOf, int repliedTo) {
        replyRepository.deleteReply(replyOf, repliedTo);
    }

    public List<Reply> getRepliesByMessageId(int messageId) {
        return replyRepository.findRepliesByMessageId(messageId);
    }
}