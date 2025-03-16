package com.example.styleSphere.global.common.enums;

import lombok.Getter;

@Getter
public enum UserStatus {

    ACTIVE("정상 유저"),
    INACTIVE("비활성 유저"),
    SUSPENDED("정지된 유저");

    private final String statusName;

    UserStatus(String statusName){
        this.statusName = statusName;
    }
}
