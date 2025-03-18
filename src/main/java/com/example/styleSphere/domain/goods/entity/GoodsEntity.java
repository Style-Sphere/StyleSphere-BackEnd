package com.example.styleSphere.domain.goods.entity;

import com.example.styleSphere.domain.question.entity.QuestionEntity;
import com.example.styleSphere.domain.review.entity.ReviewEntity;
import com.example.styleSphere.global.common.enums.SaleStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GoodsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goods_id")
    private Long id;
    @Column(nullable = false, length = 120, unique = true)
    private String goodsId;
    @Column(nullable = false, length = 50)
    private String goodsName;
    @Lob
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private Integer price;
    @Column(nullable = false)
    private Integer stock;
    @Column(nullable = false)
    private int discountRate;
    @Column(nullable = false)
    private int likeCnt;
    @Column(nullable = true)
    private String imageUrl;
    @Column(nullable = false)
    private Integer shippingFee;
    @Enumerated(EnumType.STRING)
    private SaleStatus saleStatus;
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @OneToMany(mappedBy = "goods", fetch = FetchType.LAZY)
    private List<ReviewEntity> reviews;

    @OneToMany(mappedBy = "goods", fetch = FetchType.LAZY)
    private List<QuestionEntity> questions;
}
