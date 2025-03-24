package com.example.styleSphere.domain.user.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private String email;
    private String nickname;
    private String gender;
    private String birthdate;
}
