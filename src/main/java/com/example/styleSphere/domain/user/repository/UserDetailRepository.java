package com.example.styleSphere.domain.user.repository;

import com.example.styleSphere.domain.user.entity.UserDetailEntity;
import com.example.styleSphere.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetailEntity, Integer> {
}
