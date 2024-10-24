package com.diskord.diskord.repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.diskord.diskord.model.Message;

@Repository
public class MessageRepository {

    private final JdbcTemplate jdbcTemplate;

    public MessageRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(Message message) {
        String sql = "INSERT INTO messages (is_forwarded, sender_id, message_content) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, message.isForwarded(), message.getSenderId(), message.getMessageContent());
    }

    public Message findById(int messageId) {
        String sql = "SELECT * FROM messages WHERE message_id = ?";
        return jdbcTemplate.queryForObject(sql, new MessageRowMapper(), messageId);
    }

    public List<Message> findAll() {
        String sql = "SELECT * FROM messages";
        return jdbcTemplate.query(sql, new MessageRowMapper());
    }

    public int update(Message message) {
        String sql = "UPDATE messages SET is_forwarded = ?, message_content = ? WHERE message_id = ?";
        return jdbcTemplate.update(sql, message.isForwarded(), message.getMessageContent(), message.getMessageId());
    }

    public int deleteById(int messageId) {
        String sql = "DELETE FROM messages WHERE message_id = ?";
        return jdbcTemplate.update(sql, messageId);
    }

    private static class MessageRowMapper implements RowMapper<Message> {
        @SuppressWarnings("null")
        @Override
        public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
            Message message = new Message();
            message.setMessageId(rs.getInt("message_id"));
            message.setForwarded(rs.getBoolean("is_forwarded"));
            message.setSenderId(rs.getInt("sender_id"));
            message.setMessageContent(rs.getString("message_content"));
            message.setMessageTimestamp(rs.getTimestamp("message_timestamp"));
            return message;
        }
    }
}
