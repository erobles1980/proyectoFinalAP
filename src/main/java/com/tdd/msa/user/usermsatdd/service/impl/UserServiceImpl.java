package com.tdd.msa.user.usermsatdd.service.impl;

import com.tdd.msa.user.usermsatdd.domain.UserEntity;
import com.tdd.msa.user.usermsatdd.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<UserEntity> findAll() {
        return null;
    }
}
