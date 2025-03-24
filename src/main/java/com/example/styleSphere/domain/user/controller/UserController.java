package com.example.styleSphere.domain.user.controller;

import com.example.styleSphere.domain.user.requestDTO.LoginRequestDTO;
import com.example.styleSphere.domain.user.requestDTO.UserRequestDTO;
import com.example.styleSphere.domain.user.responseDTO.LoginResponseDTO;
import com.example.styleSphere.domain.user.responseDTO.UserResponseDTO;
import com.example.styleSphere.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDTO> signup(@RequestBody UserRequestDTO requestDto) {
        UserResponseDTO responseDto = userService.signup(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request) {
        String token = userService.login(request);
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
