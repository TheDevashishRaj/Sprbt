package com.diskord.diskord.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.diskord.diskord.model.User;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(User user) {
        String sql = "INSERT INTO user (first_name, last_name, bio, email, phone) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getBio(), user.getEmail(), user.getPhone());
    }

    @SuppressWarnings("deprecation")
    public User findById(int userId) {
        String sql = "SELECT * FROM user WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, (rs, rowNum) -> {
            User user = new User();
            user.setUserId(rs.getInt("user_id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setBio(rs.getString("bio"));
            user.setJoinDate(rs.getTimestamp("join_date").toLocalDateTime());
            user.setEmail(rs.getString("email"));
            user.setPhone(rs.getString("phone"));
            return user;
        });
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            User user = new User();
            user.setUserId(rs.getInt("user_id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setBio(rs.getString("bio"));
            user.setJoinDate(rs.getTimestamp("join_date").toLocalDateTime());
            user.setEmail(rs.getString("email"));
            user.setPhone(rs.getString("phone"));
            return user;
        });
    }

    public void update(User user) {
        String sql = "UPDATE user SET first_name = ?, last_name = ?, bio = ?, email = ?, phone = ? WHERE user_id = ?";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getBio(), user.getEmail(), user.getPhone(), user.getUserId());
    }

    public void delete(int userId) {
        String sql = "DELETE FROM user WHERE user_id = ?";
        jdbcTemplate.update(sql, userId);
    }
}