package com.example.academic_management.user.repository;

import com.example.academic_management.user.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("users")
                .usingGeneratedKeyColumns("id");
    }

    public User findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?",
                new Object[]{id},
                userRowMapper());
    }

    public Long save(User user) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("student_id", user.getStudentId());
        parameters.put("name", user.getName());
        parameters.put("password", user.getPassword());
        parameters.put("grade", user.getGrade());
        parameters.put("grade_score", user.getGradeScore());
        parameters.put("department_score", user.getDepartmentScore());

        Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
        return key.longValue();
    }

    private RowMapper<User> userRowMapper() {
        return (ResultSet rs, int rowNum) -> new User(
                rs.getLong("id"),
                rs.getString("student_id"),
                rs.getString("name"),
                rs.getString("password"),
                rs.getInt("grade"),
                rs.getInt("grade_score"),
                rs.getInt("department_score"));
    }
}
