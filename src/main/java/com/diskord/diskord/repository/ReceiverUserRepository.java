package com.diskord.diskord.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.diskord.diskord.model.ReceiverUser;

@Repository
public class ReceiverUserRepository {
    private final JdbcTemplate jdbcTemplate;

    public ReceiverUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(ReceiverUser receiverUser) {
        String sql = "INSERT INTO receiver_user (message_id, receiver_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, receiverUser.getMessageId(), receiverUser.getReceiverId());
    }

    public void delete(int messageId, int receiverId) {
        String sql = "DELETE FROM receiver_user WHERE message_id = ? AND receiver_id = ?";
        jdbcTemplate.update(sql, messageId, receiverId);
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    public List<ReceiverUser> findByMessageId(int messageId) {
        String sql = "SELECT * FROM receiver_user WHERE message_id = ?";
        return (List<ReceiverUser>) jdbcTemplate.query(sql, new Object[]{messageId}, (rs, rowNum) ->
            new ReceiverUser(rs.getInt("message_id"), rs.getInt("receiver_id"))
        );
    }
}