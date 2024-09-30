package com.hydottech.Hydot.Enterprise.Suite.Backend.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String country;
    private String region;
    private String location;
    private String email;
    @Column(length = 60)
    private String password;
    private String role;
    private boolean Enabled = false;

}
