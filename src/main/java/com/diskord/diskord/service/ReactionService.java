package com.diskord.diskord.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.diskord.diskord.model.Reaction;
import com.diskord.diskord.repository.ReactionRepository;

@Service
public class ReactionService {
    private final ReactionRepository reactionRepository;

    public ReactionService(ReactionRepository reactionRepository) {
        this.reactionRepository = reactionRepository;
    }

    public void saveReaction(Reaction reaction) {
        reactionRepository.save(reaction);
    }

    public Reaction getReaction(int messageId, int reactionId) {
        return reactionRepository.findById(messageId, reactionId);
    }

    public List<Reaction> getAllReactionsByMessageId(int messageId) {
        return reactionRepository.findAllByMessageId(messageId);
    }

    public void deleteReaction(int messageId, int reactionId) {
        reactionRepository.delete(messageId, reactionId);
    }
}
