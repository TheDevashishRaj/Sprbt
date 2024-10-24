package com.diskord.diskord.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.diskord.diskord.model.Reaction;

@Repository
public class ReactionRepository {

    private final JdbcTemplate jdbcTemplate;

    public ReactionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Reaction reaction) {
        String sql = "INSERT INTO reaction (message_id, reaction_id, reaction, reacted_by) VALUES (?, ?, ?, ?)";
        System.out.println(reaction);
        jdbcTemplate.update(sql, reaction.getMessageId(), reaction.getReactionId(), reaction.getReaction(), reaction.getReactedBy());
    }

    @SuppressWarnings("deprecation")
    public Reaction findById(int messageId, int reactionId) {
        String sql = "SELECT * FROM reaction WHERE message_id = ? AND reaction_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{messageId, reactionId}, (rs, rowNum) -> {
            Reaction reaction = new Reaction();
            reaction.setMessageId(rs.getInt("message_id"));
            reaction.setReactionId(rs.getInt("reaction_id"));
            reaction.setReaction(rs.getString("reaction"));
            reaction.setReactedBy(rs.getInt("reacted_by"));
            return reaction;
        });
    }

    @SuppressWarnings("deprecation")
    public List<Reaction> findAllByMessageId(int messageId) {
        String sql = "SELECT * FROM reaction WHERE message_id = ?";
        return jdbcTemplate.query(sql, new Object[]{messageId}, (rs, rowNum) -> {
            Reaction reaction = new Reaction();
            reaction.setMessageId(rs.getInt("message_id"));
            reaction.setReactionId(rs.getInt("reaction_id"));
            reaction.setReaction(rs.getString("reaction"));
            reaction.setReactedBy(rs.getInt("reacted_by"));
            return reaction;
        });
    }

    public void delete(int messageId, int reactionId) {
        String sql = "DELETE FROM reaction WHERE message_id = ? AND reaction_id = ?";
        jdbcTemplate.update(sql, messageId, reactionId);
    }
}