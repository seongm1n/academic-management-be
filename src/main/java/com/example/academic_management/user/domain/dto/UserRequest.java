package com.example.academic_management.user.domain.dto;

public class UserRequest {
    private final String studentId;
    private final String name;
    private final int grade;
    private final int gradeScore;
    private final int departmentScore;

    public UserRequest(String studentId, String name, int grade, int gradeScore, int departmentScore) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
        this.gradeScore = gradeScore;
        this.departmentScore = departmentScore;
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
