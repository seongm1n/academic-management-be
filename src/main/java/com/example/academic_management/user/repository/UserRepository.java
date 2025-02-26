package com.example.academic_management.user.repository;

import com.example.academic_management.user.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?",
                new Object[]{id},
                userRowMapper());
    }

    private RowMapper<User> userRowMapper() {
        return (ResultSet rs, int rowNum) -> new User(
                rs.getLong("id"),
                rs.getString("student_id"),
                rs.getString("name"),
                rs.getInt("grade"),
                rs.getInt("grade_score"),
                rs.getInt("department_score"));
    }
}
