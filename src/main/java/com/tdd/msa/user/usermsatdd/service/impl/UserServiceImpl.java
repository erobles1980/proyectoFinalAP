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
        List<UserEntity> userEntities=userRepository.findAll();
        if (userEntities.isEmpty()){
            throw new EmptyListException("The list is empty");
        }
        return userEntities;
    }

    @Override
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }
}
