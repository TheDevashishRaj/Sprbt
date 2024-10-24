package com.diskord.diskord.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diskord.diskord.model.Attachment;
import com.diskord.diskord.repository.List;
import com.diskord.diskord.service.AttachmentService;

@RestController
@RequestMapping("/api/attachments")
public class AttachmentController {
    private final AttachmentService attachmentService;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @PostMapping
    public ResponseEntity<Void> createAttachment(@RequestBody Attachment attachment) {
        attachmentService.addAttachment(attachment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{fileId}/{messageId}")
    public ResponseEntity<Void> deleteAttachment(@PathVariable int fileId, @PathVariable int messageId) {
        attachmentService.removeAttachment(fileId, messageId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/message/{messageId}")
    public ResponseEntity<List<Attachment>> getAttachmentsByMessageId(@PathVariable int messageId) {
        List<Attachment> attachments = attachmentService.getAttachmentsByMessageId(messageId);
        return new ResponseEntity<>(attachments, HttpStatus.OK);
    }
}