package com.diskord.diskord.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.diskord.diskord.model.Reply;

@Repository
public class ReplyRepository {

    private final JdbcTemplate jdbcTemplate;

    public ReplyRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addReply(Reply reply) {
        String sql = "INSERT INTO reply (reply_of, replied_to) VALUES (?, ?)";
        jdbcTemplate.update(sql, reply.getReplyOf(), reply.getRepliedTo());
    }

    public void deleteReply(int replyOf, int repliedTo) {
        String sql = "DELETE FROM reply WHERE reply_of = ? AND replied_to = ?";
        jdbcTemplate.update(sql, replyOf, repliedTo);
    }

    @SuppressWarnings("deprecation")
    public List<Reply> findRepliesByMessageId(int messageId) {
        String sql = "SELECT * FROM reply WHERE reply_of = ?";
        return jdbcTemplate.query(sql, new Object[]{messageId}, (rs, rowNum) ->
                new Reply(rs.getInt("reply_of"), rs.getInt("replied_to")));
    }
}