package com.hydottech.Hydot.Enterprise.Suite.Backend.event;

import com.hydottech.Hydot.Enterprise.Suite.Backend.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.util.Objects;

@Getter
@Setter

public class RegistrationCompleteEvent extends ApplicationEvent {
private  UserEntity HomeUserEntity;
private String HomeApplicationUrl;

    public  RegistrationCompleteEvent(UserEntity userEntity, String ApplicationUrl){
        super(userEntity);
        this.HomeUserEntity = userEntity;
        this.HomeApplicationUrl = ApplicationUrl;
    }




}
