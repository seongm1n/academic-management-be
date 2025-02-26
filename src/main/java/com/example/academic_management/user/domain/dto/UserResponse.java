package com.example.academic_management.user.domain.dto;

import com.example.academic_management.user.domain.User;

public class UserResponse {
    private final Long id;
    private final String studentId;
    private final String name;
    private final int grade;
    private final int gradeScore;
    private final int departmentScore;

    public UserResponse(User user) {
        this.id = user.getId();
        this.studentId = user.getStudentId();
        this.name = user.getName();
        this.grade = user.getGrade();
        this.gradeScore = user.getGradeScore();
        this.departmentScore = user.getDepartmentScore();
    }

    public Long getId() {
        return id;
    }
    public String getStudentId() {
        return studentId;
    }
    public String getName() {
        return name;
    }
    public int getGrade() {
        return grade;
    }
    public int getGradeScore() {
        return gradeScore;
    }
    public int getDepartmentScore() {
        return departmentScore;
    }
}
