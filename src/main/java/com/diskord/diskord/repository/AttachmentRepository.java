package com.diskord.diskord.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.diskord.diskord.model.Attachment;

@Repository
public class AttachmentRepository {
    private final JdbcTemplate jdbcTemplate;

    public AttachmentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Attachment attachment) {
        String sql = "INSERT INTO attachment (file_id, message_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, attachment.getFileId(), attachment.getMessageId());
    }

    public void delete(int fileId, int messageId) {
        String sql = "DELETE FROM attachment WHERE file_id = ? AND message_id = ?";
        jdbcTemplate.update(sql, fileId, messageId);
    }
    
    @SuppressWarnings({ "deprecation", "unchecked" })
    public List<Attachment> findByMessageId(int messageId) {
        String sql = "SELECT * FROM attachment WHERE message_id = ?";
        return (List<Attachment>) jdbcTemplate.query(sql, new Object[]{messageId}, (rs, rowNum) -> 
            new Attachment(rs.getInt("file_id"), rs.getInt("message_id"))
        );
    }
}