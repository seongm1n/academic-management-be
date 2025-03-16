package com.example.academic_management.user.domain.dto;

public record UserRequest(String studentId, String name, String password, int grade, int gradeScore, int departmentScore) {
}
