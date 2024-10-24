package com.diskord.diskord.repository;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.diskord.diskord.model.CommunityGroups;

@Repository
public class CommunityGroupsRepository {

    private final JdbcTemplate jdbcTemplate;

    public CommunityGroupsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Add community-group relationship
    public void addCommunityGroup(CommunityGroups communityGroup) {
        String sql = "INSERT INTO community_groups (group_id, community_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, communityGroup.getGroupId(), communityGroup.getCommunityId());
    }

    // Delete community-group relationship
    public void deleteCommunityGroup(int groupId, int communityId) {
        String sql = "DELETE FROM community_groups WHERE group_id = ? AND community_id = ?";
        jdbcTemplate.update(sql, groupId, communityId);
    }

    // Get all groups associated with a specific community
    @SuppressWarnings("deprecation")
    public List<CommunityGroups> findGroupsByCommunityId(int communityId) {
        String sql = "SELECT * FROM community_groups WHERE community_id = ?";
        return jdbcTemplate.query(sql, new Object[]{communityId}, (rs, rowNum) -> 
            new CommunityGroups(rs.getInt("group_id"), rs.getInt("community_id")));
    }

    // Get all communities associated with a specific group
    @SuppressWarnings("deprecation")
    public List<CommunityGroups> findCommunitiesByGroupId(int groupId) {
        String sql = "SELECT * FROM community_groups WHERE group_id = ?";
        return jdbcTemplate.query(sql, new Object[]{groupId}, (rs, rowNum) -> 
            new CommunityGroups(rs.getInt("group_id"), rs.getInt("community_id")));
    }
}