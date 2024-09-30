package com.hydottech.Hydot.Enterprise.Suite.Backend.listener;

import com.hydottech.Hydot.Enterprise.Suite.Backend.entity.UserEntity;
import com.hydottech.Hydot.Enterprise.Suite.Backend.event.RegistrationCompleteEvent;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        UserEntity userEntity = event.getHomeUserEntity();
        String token = UUID.randomUUID().toString();

    }
}
