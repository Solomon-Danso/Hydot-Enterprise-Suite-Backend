package com.hydottech.Hydot.Enterprise.Suite.Backend.services;

import com.hydottech.Hydot.Enterprise.Suite.Backend.entity.UserEntity;
import com.hydottech.Hydot.Enterprise.Suite.Backend.model.UserModel;
import com.hydottech.Hydot.Enterprise.Suite.Backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementaion implements UserServiceInterface{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserEntity registerUser(UserModel userModel) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userModel.getEmail());
        userEntity.setFirstName(userModel.getFirstName());
        userEntity.setLastName(userModel.getLastName());
        userEntity.setPhoneNumber(userModel.getPhoneNumber());
        userEntity.setCountry(userModel.getCountry());
        userEntity.setRegion(userModel.getRegion());
        userEntity.setLocation(userModel.getLocation());
        userEntity.setPassword( passwordEncoder.encode( userModel.getPassword() ) );
        userEntity.setRole("Staff");

        userRepository.save(userEntity);
        return userEntity;
    }
}
