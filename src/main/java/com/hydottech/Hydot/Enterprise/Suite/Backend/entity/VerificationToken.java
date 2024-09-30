package com.hydottech.Hydot.Enterprise.Suite.Backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
public class VerificationToken {

    private static final int EXPIRATION_TIME = 10;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private String Token;
    private Date ExpirationTime;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_USER_VERIFY_TOKEN"))

    private UserEntity userEntity;

    private VerificationToken(UserEntity user, String token){
      super();
      this.Token = token;
      this.userEntity = user;
      this.ExpirationTime = calculateExpirationDate(EXPIRATION_TIME);
    }

    private VerificationToken(String token){
        super();
        this.Token = token;
        this.ExpirationTime = calculateExpirationDate(EXPIRATION_TIME);
    }

    private Date calculateExpirationDate(int expirationTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE, expirationTime);
        return new Date(calendar.getTime().getTime());
    }

}
