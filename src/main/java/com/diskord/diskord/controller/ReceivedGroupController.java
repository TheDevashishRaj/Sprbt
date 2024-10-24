package com.diskord.diskord.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diskord.diskord.model.ReceivedGroup;
import com.diskord.diskord.service.ReceivedGroupService;

@RestController
@RequestMapping("/api/received-groups")
public class ReceivedGroupController {

    private final ReceivedGroupService service;

    public ReceivedGroupController(ReceivedGroupService service) {
        this.service = service;
    }

    // Add a new received group
    @PostMapping
    public ResponseEntity<String> addReceivedGroup(@RequestBody ReceivedGroup receivedGroup) {
        service.saveReceivedGroup(receivedGroup);
        return new ResponseEntity<>("Received group saved successfully!", HttpStatus.CREATED);
    }

    // Get all received groups
    @GetMapping
    public List<ReceivedGroup> getAllReceivedGroups() {
        return service.getAllReceivedGroups();
    }

    // Get received groups by message ID
    @GetMapping("/{messageId}")
    public List<ReceivedGroup> getReceivedGroupsByMessageId(@PathVariable int messageId) {
        return service.getReceivedGroupsByMessageId(messageId);
    }

    // Delete a received group
    @DeleteMapping("/{messageId}/{groupId}")
    public ResponseEntity<String> deleteReceivedGroup(@PathVariable int messageId, @PathVariable int groupId) {
        service.deleteReceivedGroup(messageId, groupId);
        return new ResponseEntity<>("Received group deleted successfully!", HttpStatus.OK);
    }
}