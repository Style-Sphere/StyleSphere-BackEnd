package com.example.styleSphere.domain.user.service;


import com.example.styleSphere.domain.user.requestDTO.UserRequestDTO;
import com.example.styleSphere.domain.user.responseDTO.UserResponseDTO;

public interface UserService {
    UserResponseDTO signup(UserRequestDTO requestDto);
}
