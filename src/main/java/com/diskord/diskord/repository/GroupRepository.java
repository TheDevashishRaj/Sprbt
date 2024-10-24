package com.diskord.diskord.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.diskord.diskord.model.Group;

@Repository
public class GroupRepository {
    private final JdbcTemplate jdbcTemplate;

    public GroupRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Group group) {
        String sql = "INSERT INTO groupchat (group_name, invite_link, group_description) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, group.getGroupName(), group.getInviteLink(), group.getGroupDescription());
    }

    public List<Group> findAll() {
        String sql = "SELECT * FROM groupchat";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Group group = new Group();
            group.setGroupId(rs.getInt("group_id"));
            group.setGroupName(rs.getString("group_name"));
            group.setInviteLink(rs.getString("invite_link"));
            group.setGroupDescription(rs.getString("group_description"));
            group.setCreationDate(rs.getTimestamp("creation_date"));
            return group;
        });
    }

    @SuppressWarnings("deprecation")
    public Group findById(int groupId) {
        String sql = "SELECT * FROM groupchat WHERE group_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{groupId}, (rs, rowNum) -> {
            Group group = new Group();
            group.setGroupId(rs.getInt("group_id"));
            group.setGroupName(rs.getString("group_name"));
            group.setInviteLink(rs.getString("invite_link"));
            group.setGroupDescription(rs.getString("group_description"));
            group.setCreationDate(rs.getTimestamp("creation_date"));
            return group;
        });
    }

    public void update(Group group) {
        String sql = "UPDATE groupchat SET group_name = ?, invite_link = ?, group_description = ? WHERE group_id = ?";
        jdbcTemplate.update(sql, group.getGroupName(), group.getInviteLink(), group.getGroupDescription(), group.getGroupId());
    }

    public void delete(int groupId) {
        String sql = "DELETE FROM groupchat WHERE group_id = ?";
        jdbcTemplate.update(sql, groupId);
    }
}