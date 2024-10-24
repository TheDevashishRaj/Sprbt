package com.diskord.diskord.repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.diskord.diskord.model.Community;

@Repository
public class CommunityRepository {

    private final JdbcTemplate jdbcTemplate;

    public CommunityRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(Community community) {
        String sql = "INSERT INTO community (community_name, community_desc) VALUES (?, ?)";
        return jdbcTemplate.update(sql, community.getCommunityName(), community.getCommunityDesc());
    }

    @SuppressWarnings("deprecation")
    public Community findById(int id) {
        String sql = "SELECT * FROM community WHERE community_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new CommunityRowMapper());
    }

    public List<Community> findAll() {
        String sql = "SELECT * FROM community";
        return jdbcTemplate.query(sql, new CommunityRowMapper());
    }

    public int update(Community community) {
        String sql = "UPDATE community SET community_name = ?, community_desc = ? WHERE community_id = ?";
        return jdbcTemplate.update(sql, community.getCommunityName(), community.getCommunityDesc(), community.getCommunityId());
    }

    public int deleteById(int id) {
        String sql = "DELETE FROM community WHERE community_id = ?";
        return jdbcTemplate.update(sql, id);
    }

    private static class CommunityRowMapper implements RowMapper<Community> {
        @SuppressWarnings("null")
        @Override
        public Community mapRow(ResultSet rs, int rowNum) throws SQLException {
            Community community = new Community();
            community.setCommunityId(rs.getInt("community_id"));
            community.setCommunityName(rs.getString("community_name"));
            community.setCommunityDesc(rs.getString("community_desc"));
            community.setCreationTimestamp(rs.getTimestamp("creation_timestamp").toLocalDateTime());
            return community;
        }
    }
}
