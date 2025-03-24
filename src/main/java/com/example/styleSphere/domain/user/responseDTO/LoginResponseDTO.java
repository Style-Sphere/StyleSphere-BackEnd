package com.example.styleSphere.domain.user.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponseDTO {
    private String token;      // JWT 액세스 토큰
}
