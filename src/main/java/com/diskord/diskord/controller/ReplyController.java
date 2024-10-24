package com.diskord.diskord.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diskord.diskord.model.Reply;
import com.diskord.diskord.service.ReplyService;

@RestController
@RequestMapping("/api/replies")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    // Add a new reply relationship (POST)
    @PostMapping("/add")
    public ResponseEntity<String> addReply(@RequestBody Reply reply) {
        try {
            replyService.addReply(reply);
            return new ResponseEntity<>("Reply relationship added successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add reply relationship.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete a reply relationship (POST with JSON request body)
    @PostMapping("/delete")
    public ResponseEntity<String> deleteReply(@RequestBody Reply reply) {
        try {
            replyService.removeReply(reply.getReplyOf(), reply.getRepliedTo());
            return new ResponseEntity<>("Reply relationship removed successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to remove reply relationship.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get all replies of a specific message (POST with JSON request body)
    @PostMapping("/get")
    public ResponseEntity<List<Reply>> getRepliesByMessageId(@RequestBody Reply reply) {
        try {
            List<Reply> replies = replyService.getRepliesByMessageId(reply.getReplyOf());
            return new ResponseEntity<>(replies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}