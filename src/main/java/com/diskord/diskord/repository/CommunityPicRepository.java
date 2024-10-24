package com.diskord.diskord.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.diskord.diskord.model.CommunityPic;

@Repository
public class CommunityPicRepository {

    private final JdbcTemplate jdbcTemplate;

    public CommunityPicRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private CommunityPic mapRowToCommunityPic(ResultSet rs, int rowNum) throws SQLException {
        CommunityPic communityPic = new CommunityPic();
        communityPic.setFileId(rs.getInt("file_id"));
        communityPic.setCommunityId(rs.getInt("community_id"));
        return communityPic;
    }

    public int save(CommunityPic communityPic) {
        String sql = "INSERT INTO community_pic (file_id, community_id) VALUES (?, ?)";
        return jdbcTemplate.update(sql, communityPic.getFileId(), communityPic.getCommunityId());
    }

    public List<CommunityPic> findAll() {
        String sql = "SELECT * FROM community_pic";
        return jdbcTemplate.query(sql, this::mapRowToCommunityPic);
    }

    @SuppressWarnings("deprecation")
    public CommunityPic findById(int fileId, int communityId) {
        String sql = "SELECT * FROM community_pic WHERE file_id = ? AND community_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{fileId, communityId}, this::mapRowToCommunityPic);
    }

    public int delete(int fileId, int communityId) {
        String sql = "DELETE FROM community_pic WHERE file_id = ? AND community_id = ?";
        return jdbcTemplate.update(sql, fileId, communityId);
    }
}
