package com.diskord.diskord.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.diskord.diskord.model.ProfilePic;
import java.util.List;

@Repository
public class ProfilePicRepository {
    private final JdbcTemplate jdbcTemplate;

    public ProfilePicRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(ProfilePic profilePic) {
        String sql = "INSERT INTO profile_pic (file_id, user_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, profilePic.getFileId(), profilePic.getUserId());
    }

    public void delete(int fileId, int userId) {
        String sql = "DELETE FROM profile_pic WHERE file_id = ? AND user_id = ?";
        jdbcTemplate.update(sql, fileId, userId);
    }

    public List<ProfilePic> findByUserId(int userId) {
        String sql = "SELECT * FROM profile_pic WHERE user_id = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new ProfilePic(rs.getInt("file_id"), rs.getInt("user_id")), userId);
    }

    public List<ProfilePic> findByFileId(int fileId) {
        String sql = "SELECT * FROM profile_pic WHERE file_id = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new ProfilePic(rs.getInt("file_id"), rs.getInt("user_id")), fileId);
    }
}