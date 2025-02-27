package com.example.academic_management.user.service;

import com.example.academic_management.user.domain.User;
import com.example.academic_management.user.domain.dto.UserRequest;
import com.example.academic_management.user.domain.dto.UserResponse;
import com.example.academic_management.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse findById(Long id) {
        User user = userRepository.findById(id);
        return new UserResponse(user);
    }

    public UserResponse signInUser(UserRequest request) {
        User user = new User(null, request.getStudentId(), request.getName(), request.getGrade(), request.getGradeScore(), request.getDepartmentScore());
        Long id = userRepository.save(user);
        return new UserResponse(new User(id, user.getStudentId(), user.getName(), user.getGrade(), user.getGradeScore(), user.getDepartmentScore()));
    }
}
