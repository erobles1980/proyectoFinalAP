package com.tdd.msa.user.usermsatdd.repository;

import com.tdd.msa.user.usermsatdd.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {

}
