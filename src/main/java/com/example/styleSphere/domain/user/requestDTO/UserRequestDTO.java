package com.example.styleSphere.domain.user.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
    private String email;
    private String password;
    private String nickname;
    private String phoneNumber;
    private String address;
    private String gender;
    private String birth;
}
