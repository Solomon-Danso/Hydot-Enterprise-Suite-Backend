package com.hydottech.Hydot.Enterprise.Suite.Backend.controller;

import com.hydottech.Hydot.Enterprise.Suite.Backend.entity.UserEntity;
import com.hydottech.Hydot.Enterprise.Suite.Backend.event.RegistrationCompleteEvent;
import com.hydottech.Hydot.Enterprise.Suite.Backend.model.UserModel;
import com.hydottech.Hydot.Enterprise.Suite.Backend.services.UserServiceImplementaion;
import com.hydottech.Hydot.Enterprise.Suite.Backend.services.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {



    @Autowired
    private UserServiceInterface userServiceInterface;

    @Autowired
    private ApplicationEventPublisher publisher;


    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel){
        UserEntity user = userServiceInterface.registerUser(userModel);
        publisher.publishEvent(new RegistrationCompleteEvent(user, "UrL"));

        return "Success";
    }


}
