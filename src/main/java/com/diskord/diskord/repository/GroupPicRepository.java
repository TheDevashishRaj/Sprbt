package com.diskord.diskord.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.diskord.diskord.model.GroupPic;

import java.util.List;

@Repository
public class GroupPicRepository {
    private final JdbcTemplate jdbcTemplate;

    public GroupPicRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(GroupPic groupPic) {
        String sql = "INSERT INTO group_pic (file_id, group_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, groupPic.getFileId(), groupPic.getGroupId());
    }

    public void delete(int fileId, int groupId) {
        String sql = "DELETE FROM group_pic WHERE file_id = ? AND group_id = ?";
        jdbcTemplate.update(sql, fileId, groupId);
    }

    public List<GroupPic> findByGroupId(int groupId) {
        String sql = "SELECT * FROM group_pic WHERE group_id = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new GroupPic(rs.getInt("file_id"), rs.getInt("group_id")), groupId);
    }

    public List<GroupPic> findByFileId(int fileId) {
        String sql = "SELECT * FROM group_pic WHERE file_id = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new GroupPic(rs.getInt("file_id"), rs.getInt("group_id")), fileId);
    }
}