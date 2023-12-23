package com.tdd.msa.user.usermsatdd.service.impl;

import com.tdd.msa.user.usermsatdd.domain.UserEntity;
import com.tdd.msa.user.usermsatdd.repository.UserRepository;
import com.tdd.msa.user.usermsatdd.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserEntity> findAll() {
        if (userRepository.findAll().isEmpty()){
            throw new EmptyListException("The list is empty");
        }
        return userRepository.findAll();
    }
}
