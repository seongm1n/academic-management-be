CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    student_id VARCHAR(50) NOT NULL,
    name VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    grade INT NOT NULL,
    grade_score INT NOT NULL,
    department_score INT NOT NULL
);
