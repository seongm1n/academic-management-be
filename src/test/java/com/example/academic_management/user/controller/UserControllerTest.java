package com.example.academic_management.user.controller;

import com.example.academic_management.user.domain.User;
import com.example.academic_management.user.domain.dto.UserRequest;
import com.example.academic_management.user.domain.dto.UserResponse;
import com.example.academic_management.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    public void testCreateUser() throws Exception {
        UserResponse userResponse = new UserResponse(new User(1L, "20180595", "김성민", 4, 1000, 200));

        doReturn(userResponse).when(userService).signInUser(any(UserRequest.class));

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"studentId\":\"20180595\",\"name\":\"김성민\",\"grade\":4,\"gradeScore\":1000,\"departmentScore\":200}"))
                .andExpect(status().isCreated())
                .andExpect(content().json("{\"id\":1,\"studentId\":\"20180595\",\"name\":\"김성민\",\"grade\":4,\"gradeScore\":1000,\"departmentScore\":200}"));
    }

    @Test
    public void testGetUser() throws Exception {
        UserResponse userResponse = new UserResponse(new User(1L, "20180595", "김성민", 4, 1000, 200));
        when(userService.findById(1L)).thenReturn(userResponse);

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"studentId\":\"20180595\",\"name\":\"김성민\",\"grade\":4,\"gradeScore\":1000,\"departmentScore\":200}"));
    }
}
