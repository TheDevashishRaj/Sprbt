package com.diskord.diskord.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diskord.diskord.model.ReceiverUser;
import com.diskord.diskord.repository.List;
import com.diskord.diskord.service.ReceiverUserService;

@RestController
@RequestMapping("/api/receivers")
public class ReceiverUserController {
    private final ReceiverUserService receiverUserService;

    public ReceiverUserController(ReceiverUserService receiverUserService) {
        this.receiverUserService = receiverUserService;
    }

    // Endpoint to create a receiver_user
    @PostMapping
    public ResponseEntity<Void> createReceiverUser(@RequestBody ReceiverUser receiverUser) {
        receiverUserService.saveReceiverUser(receiverUser);
        return ResponseEntity.status(201).build();
    }

    // Endpoint to delete a receiver_user
    @DeleteMapping("/{messageId}/{receiverId}")
    public ResponseEntity<Void> deleteReceiverUser(@PathVariable int messageId, @PathVariable int receiverId) {
        receiverUserService.deleteReceiverUser(messageId, receiverId);
        return ResponseEntity.noContent().build();
    }

    // Endpoint to get receivers by message ID
    @GetMapping("/message/{messageId}")
    public ResponseEntity<List<ReceiverUser>> getReceiversByMessageId(@PathVariable int messageId) {
        List<ReceiverUser> receivers = receiverUserService.getReceiversByMessageId(messageId);
        return ResponseEntity.ok(receivers);
    }
}