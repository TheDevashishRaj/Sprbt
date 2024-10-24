package com.diskord.diskord.service;

import org.springframework.stereotype.Service;

import com.diskord.diskord.model.Attachment;
import com.diskord.diskord.repository.AttachmentRepository;
import com.diskord.diskord.repository.List;

@Service
public class AttachmentService {
    private final AttachmentRepository attachmentRepository;

    public AttachmentService(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    public void addAttachment(Attachment attachment) {
        attachmentRepository.save(attachment);
    }

    public void removeAttachment(int fileId, int messageId) {
        attachmentRepository.delete(fileId, messageId);
    }

    public List<Attachment> getAttachmentsByMessageId(int messageId) {
        return attachmentRepository.findByMessageId(messageId);
    }
}