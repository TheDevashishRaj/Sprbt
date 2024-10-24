package com.diskord.diskord.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diskord.diskord.model.Reaction;
import com.diskord.diskord.service.ReactionService;

@RestController
@RequestMapping("/api/reactions")
public class ReactionController {

    private final ReactionService reactionService;

    public ReactionController(ReactionService reactionService) {
        this.reactionService = reactionService;
    }

    @PostMapping
    public ResponseEntity<Void> createReaction(@RequestBody Reaction reaction) {
        System.out.println("Received Reactionctrl: " + reaction);
        reactionService.saveReaction(reaction);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{messageId}/{reactionId}")
    public ResponseEntity<Reaction> getReaction(@PathVariable int messageId, @PathVariable int reactionId) {
        Reaction reaction = reactionService.getReaction(messageId, reactionId);
        return ResponseEntity.ok(reaction);
    }

    @GetMapping("/message/{messageId}")
    public ResponseEntity<List<Reaction>> getAllReactions(@PathVariable int messageId) {
        List<Reaction> reactions = reactionService.getAllReactionsByMessageId(messageId);
        return ResponseEntity.ok(reactions);
    }

    @DeleteMapping("/{messageId}/{reactionId}")
    public ResponseEntity<Void> deleteReaction(@PathVariable int messageId, @PathVariable int reactionId) {
        reactionService.deleteReaction(messageId, reactionId);
        return ResponseEntity.noContent().build();
    }
}

