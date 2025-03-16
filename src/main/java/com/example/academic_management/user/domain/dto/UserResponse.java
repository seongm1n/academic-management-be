package com.example.academic_management.user.domain.dto;

import com.example.academic_management.user.domain.User;

public record UserResponse(Long id, String studentId, String name, String password, int grade, int gradeScore, int departmentScore) {
    public UserResponse(User user) {
        this(user.getId(), user.getStudentId(), user.getName(), user.getPassword(), user.getGrade(), user.getGradeScore(), user.getDepartmentScore());
    }
}
