package com.example.styleSphere.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    private String email;
    private String password;
    private String nickname;
    private String phoneNumber;
    private String address;
    private String gender;
    private String birth;
}
