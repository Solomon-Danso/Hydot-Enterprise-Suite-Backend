package com.hydottech.HES_Backend.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;  // Change to camelCase
    private String picture;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String password;
    private boolean isBlocked;
    private boolean isPasswordReset;
    private String primaryRole;

    @CreationTimestamp
    private LocalDateTime dateCreated;

}
