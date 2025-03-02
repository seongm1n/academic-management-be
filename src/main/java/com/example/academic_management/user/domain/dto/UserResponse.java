package com.example.academic_management.user.domain.dto;

import com.example.academic_management.user.domain.User;

public record UserResponse(Long id, String studentId, String name, int grade, int gradeScore, int departmentScore) {
    public UserResponse(User user) {
        this(user.getId(), user.getStudentId(), user.getName(), user.getGrade(), user.getGradeScore(), user.getDepartmentScore());
    }
}
