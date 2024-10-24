package com.diskord.diskord.repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.diskord.diskord.model.Member;

@Repository
public class MemberRepository {

    private final JdbcTemplate jdbcTemplate;

    public MemberRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Member mapRowToMember(ResultSet rs, int rowNum) throws SQLException {
        Member member = new Member();
        member.setUserId(rs.getInt("user_id"));
        member.setGroupId(rs.getInt("group_id"));
        return member;
    }

    public int save(Member member) {
        String sql = "INSERT INTO member (user_id, group_id) VALUES (?, ?)";
        return jdbcTemplate.update(sql, member.getUserId(), member.getGroupId());
    }

    public List<Member> findAll() {
        String sql = "SELECT * FROM member";
        return jdbcTemplate.query(sql, this::mapRowToMember);
    }

    @SuppressWarnings("deprecation")
    public Member findById(int userId, int groupId) {
        String sql = "SELECT * FROM member WHERE user_id = ? AND group_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId, groupId}, this::mapRowToMember);
    }

    public int delete(int userId, int groupId) {
        String sql = "DELETE FROM member WHERE user_id = ? AND group_id = ?";
        return jdbcTemplate.update(sql, userId, groupId);
    }
}