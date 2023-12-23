package com.tdd.msa.user.usermsatdd.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "T_USERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false)
    private Integer id;

    @Column(name="USR_NAME", nullable = false)
    private String name;

    @Column(name="USR_PHONE",nullable = false)
    private String phoneNumber;

    @Column(name="USR_DIRECTION",nullable = false)
    private String direction;

}
