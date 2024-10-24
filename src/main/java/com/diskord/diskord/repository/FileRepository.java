package com.diskord.diskord.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.diskord.diskord.model.File;

@Repository
public class FileRepository {

    private final JdbcTemplate jdbcTemplate;

    public FileRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void save(File file) {
        String sql = "INSERT INTO file (file_data, file_type, size) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, file.getFileData(), file.getFileType(), file.getSize());
    }

    @SuppressWarnings("deprecation")
    public File findById(int id) {
        String sql = "SELECT * FROM file WHERE file_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> 
            new File(rs.getInt("file_id"),
                     rs.getBytes("file_data"),
                     rs.getString("file_type"),
                     rs.getInt("size")));
    }

    public List<File> findAll() {
        String sql = "SELECT * FROM file";
        return jdbcTemplate.query(sql, (rs, rowNum) -> 
            new File(rs.getInt("file_id"),
                     rs.getBytes("file_data"),
                     rs.getString("file_type"),
                     rs.getInt("size")));
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM file WHERE file_id = ?";
        jdbcTemplate.update(sql, id);
    }
}