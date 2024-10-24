package com.diskord.diskord.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.diskord.diskord.model.ReceivedGroup;

@Repository
public class ReceivedGroupRepository {

    private final JdbcTemplate jdbcTemplate;

    public ReceivedGroupRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Save received group record
    public int save(ReceivedGroup receivedGroup) {
        String sql = "INSERT INTO received_grp (message_id, group_id) VALUES (?, ?)";
        return jdbcTemplate.update(sql, receivedGroup.getMessageId(), receivedGroup.getGroupId());
    }

    // Find received group by message ID
    public List<ReceivedGroup> findByMessageId(int messageId) {
        String sql = "SELECT * FROM received_grp WHERE message_id = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new ReceivedGroup(
                rs.getInt("message_id"),
                rs.getInt("group_id")
        ), messageId);
    }

    // Find all received groups
    public List<ReceivedGroup> findAll() {
        String sql = "SELECT * FROM received_grp";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new ReceivedGroup(
                rs.getInt("message_id"),
                rs.getInt("group_id")
        ));
    }

    // Delete received group by messageId and groupId
    public int delete(int messageId, int groupId) {
        String sql = "DELETE FROM received_grp WHERE message_id = ? AND group_id = ?";
        return jdbcTemplate.update(sql, messageId, groupId);
    }
}