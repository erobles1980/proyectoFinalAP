package com.tdd.msa.user.usermsatdd.service;

import com.tdd.msa.user.usermsatdd.domain.UserEntity;
import com.tdd.msa.user.usermsatdd.repository.UserRepository;
import com.tdd.msa.user.usermsatdd.service.impl.EmptyListException;
import com.tdd.msa.user.usermsatdd.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;


import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userServiceImplMock;

    @Mock
    private UserRepository userRepository;

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
        when(userRepository.findAll()).thenReturn(expectedUserEntites);
        List<UserEntity> userEntities=userServiceImplMock.findAll();

        //@Then - son las aserciones que validen las respuesta de lo que se devuelva
        assertNotNull(userEntities,"This object should not be null");
        assertEquals(expectedUserEntites.get(0).getId(),userEntities.get(0).getId());
    }

    @Test
    @DisplayName("USI_CA2: When I call the findAll method and it has no data, then it should throw an exception")
    void whenCallFindAllMethodAndItHasNoDataThenShouldThrowException(){
        //@Given

        //@When
        when(userRepository.findAll()).thenReturn(List.of());

        //@Then
        //assertFalse(userEntities.isEmpty());
        assertThrows(EmptyListException.class, () -> userServiceImplMock.findAll());
    }

    @Test
    @DisplayName("USI_CA3: When I call the createUser, it should save")
    void testCreateUser() {
        // Given
        UserEntity user = new UserEntity();
        user.setName("erobles");
        user.setPhoneNumber("123456789");
        user.setDirection("Urdenor");

        //@When
        when(userRepository.save(user)).thenReturn(user);

        // Act
        UserEntity createdUser = userServiceImplMock.createUser(user);

        // Assert
        assertEquals(user.getName(), createdUser.getName());
        assertEquals(user.getPhoneNumber(), createdUser.getPhoneNumber());
        assertEquals(user.getDirection(), createdUser.getDirection());
        verify(userRepository, times(1)).save(user);
    }
}
