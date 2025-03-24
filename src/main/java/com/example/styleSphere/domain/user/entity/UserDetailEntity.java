package com.example.styleSphere.domain.user.entity;

import com.example.styleSphere.global.common.enums.UserGrade;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Setter
@Table(name = "user_detail")
public class UserDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_detail_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private String nickname;  // 닉네임

    private String gender;  // 성별

    private String birthdate;  // 생년월일

    private Integer totalPrice;  // 구매누적금액

    private Integer accumulatedPoints;  // 적립금

    @Enumerated(EnumType.STRING)
    private UserGrade membershipGrade;  // 유저 등급

}
