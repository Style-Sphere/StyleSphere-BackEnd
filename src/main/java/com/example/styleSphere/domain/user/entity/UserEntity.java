package com.example.styleSphere.domain.user.entity;

import com.example.styleSphere.domain.cart.entity.CartEntity;
import com.example.styleSphere.domain.order.entity.OrderEntity;
import com.example.styleSphere.domain.question.entity.QuestionEntity;
import com.example.styleSphere.domain.refund.entity.RefundEntity;
import com.example.styleSphere.domain.reward.entity.RewardPointEntity;
import com.example.styleSphere.global.common.enums.UserRole;
import com.example.styleSphere.global.common.enums.UserStatus;
import com.example.styleSphere.domain.coupon.entity.CouponEntity;
import com.example.styleSphere.domain.like.entity.LikeEntity;
import com.example.styleSphere.domain.review.entity.ReviewEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;  // 이메일

    @Column(nullable = false)
    private String password;  // 비밀번호

    @Column(nullable = false)
    private String phoneNumber;  // 휴대폰 번호

    @Column(nullable = false)
    private String address;  // 주소

    @Enumerated(EnumType.STRING)
    private UserRole role;  // 유저 권한

    @Enumerated(EnumType.STRING)
    private UserStatus status;  // 상태

    private LocalDateTime createdDate;  // 회원 가입 일시
    private LocalDateTime lastLoginDate;  // 마지막 로그인 일시

    @OneToOne(mappedBy = "user")
    private UserDetailEntity userDetails;  // 상세 정보

    @OneToMany(mappedBy = "user")
    private List<OrderEntity> orders;  // 주문 내역

    @OneToOne(mappedBy = "user")
    private List<CartEntity> cartItems;  // 장바구니

    @OneToMany(mappedBy = "user")
    private List<LikeEntity> likeItems;  // 좋아요한 항목

    @OneToMany(mappedBy = "user")
    private List<ReviewEntity> reviews;  // 작성한 상품 후기

    @OneToMany(mappedBy = "user")
    private List<QuestionEntity> questions;  // 작성한 문의

    @OneToMany(mappedBy = "user")
    private List<CouponEntity> coupons;  // 보유한 쿠폰

    @OneToMany(mappedBy = "user")
    private List<RefundEntity> refunds;  // 취소/반품 내역

    @OneToMany(mappedBy = "user")
    private List<RewardPointEntity> rewardPoints;  // 적립금 내역

}
