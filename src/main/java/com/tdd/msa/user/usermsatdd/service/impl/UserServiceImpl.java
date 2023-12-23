package com.tdd.msa.user.usermsatdd.service.impl;

import com.tdd.msa.user.usermsatdd.domain.UserEntity;
import com.tdd.msa.user.usermsatdd.repository.UserRepository;
import com.tdd.msa.user.usermsatdd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> findAll() {
        List<UserEntity> userEntities=userRepository.findAll();
        return userEntities;
    }
}
