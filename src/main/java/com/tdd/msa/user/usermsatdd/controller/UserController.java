package com.tdd.msa.user.usermsatdd.controller;

import com.tdd.msa.user.usermsatdd.domain.UserEntity;
import com.tdd.msa.user.usermsatdd.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.findAll();
    }

//    // Obtener un usuario por ID
//    @GetMapping("/{id}")
//    public ResponseEntity<UserEntity> getUserById(@PathVariable Integer id) {
//        return userService.findUserById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
    // Crear un nuevo usuario
    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userService.createUser(user);
    }
//
//    // Actualizar un usuario existente
//    @PutMapping("/{id}")
//    public ResponseEntity<UserEntity> updateUser(@PathVariable Integer id, @RequestBody UserEntity user) {
//        return userService.updateUser(id, user)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    // Eliminar un usuario
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
//        if (userService.deleteUser(id)) {
//            return ResponseEntity.ok().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
}
