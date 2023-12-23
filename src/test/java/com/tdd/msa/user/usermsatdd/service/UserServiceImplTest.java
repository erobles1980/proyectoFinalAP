package com.tdd.msa.user.usermsatdd.service;

import com.tdd.msa.user.usermsatdd.domain.UserEntity;
import com.tdd.msa.user.usermsatdd.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userServiceImplMock;

    private List<UserEntity> expectedUserEntites;

    @BeforeEach
    public void setUp(){
        expectedUserEntites= Arrays.asList(UserEntity.builder().
                            id(1).name("Ernesto").direction("Guayaquil")
                            .phoneNumber("0987654321").build());
    }

    @Test
    @DisplayName("USI_CA1: When call findAll method then return  List of Users")
    void whenCallFindAllMethodThenReturnListOfUsersTest(){
        //@Given - setear los parametros de entrada segun lo requiera

        //@When - llama al metodo o simulamos los llamados
        List<UserEntity> userEntities=userServiceImplMock.findAll();

        //@Then - son las acerciones que validen las respuesta de lo que se devuelva
        assertNotNull(userEntities,"This object should not be null");
    }
}
