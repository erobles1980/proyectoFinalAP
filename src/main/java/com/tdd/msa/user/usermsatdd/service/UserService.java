package com.tdd.msa.user.usermsatdd.service;

import com.tdd.msa.user.usermsatdd.domain.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> findAll();
}
