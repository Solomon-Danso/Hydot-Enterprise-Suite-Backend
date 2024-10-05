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
    private String UserId;
    private String Picture;
    private String FullName;
    private String Email;
    private String PhoneNumber;
    private String Password;
    private boolean IsBlocked;
    private boolean IsPasswordReset;
    private String PrimaryRole;

    @CreationTimestamp
    private LocalDateTime DateCreated;

}
