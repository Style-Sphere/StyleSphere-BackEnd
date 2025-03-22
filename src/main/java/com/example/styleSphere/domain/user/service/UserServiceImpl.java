package com.example.styleSphere.domain.user.service;

import com.example.styleSphere.domain.user.requestDTO.UserRequestDTO;
import com.example.styleSphere.domain.user.entity.UserDetailEntity;
import com.example.styleSphere.domain.user.entity.UserEntity;
import com.example.styleSphere.domain.user.repository.UserDetailRepository;
import com.example.styleSphere.domain.user.repository.UserRepository;
import com.example.styleSphere.domain.user.responseDTO.UserResponseDTO;
import com.example.styleSphere.global.common.enums.UserGrade;
import com.example.styleSphere.global.common.enums.UserRole;
import com.example.styleSphere.global.common.enums.UserStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDetailRepository userDetailRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDTO signup(UserRequestDTO requestDto) {
        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(requestDto.getPassword());

        // 1. UserEntity 생성
        UserEntity user = UserEntity.builder()
                .email(requestDto.getEmail())
                .password(encodedPassword)
                .phoneNumber(requestDto.getPhoneNumber())
                .address(requestDto.getAddress())
                .role(UserRole.USER)  // 기본 권한 설정
                .status(UserStatus.ACTIVE)  // 기본 상태 설정
                .createdDate(LocalDateTime.now())
                .build();
        // 저장
        userRepository.save(user);


        // 2. UserDetailEntity 생성
        UserDetailEntity userDetail = UserDetailEntity.builder()
                .user(user)
                .nickname(requestDto.getNickname())
                .gender(requestDto.getGender())
                .birthdate(requestDto.getBirth())
                .totalPrice(0)
                .accumulatedPoints(0)
                .membershipGrade(UserGrade.BRONZE)
                .build();

        userDetailRepository.save(userDetail);

        return new UserResponseDTO(
                user.getEmail(),
                userDetail.getNickname(),
                userDetail.getGender(),
                userDetail.getBirthdate()
        );
    }
}
