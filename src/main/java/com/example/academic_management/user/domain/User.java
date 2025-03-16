package com.example.academic_management.user.domain;

public class User {
    private final Long id;
    private final String StudentId;
    private final String name;
    private final String password;
    private final int grade;
    private final int gradeScore;
    private final int departmentScore;

    public User(Long id, String StudentId, String name, String password, int grade, int gradeScore, int departmentScore) {
        this.id = id;
        this.StudentId = StudentId;
        this.name = name;
        this.password = password;
        this.grade = grade;
        this.gradeScore = gradeScore;
        this.departmentScore = departmentScore;
    }

    public Long getId() {
        return id;
    }

    public String getStudentId() {
        return StudentId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
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
