package com.hydottech.HES_Backend.Service;

import com.hydottech.HES_Backend.Entity.Users;
import com.hydottech.HES_Backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements  UserServiceInterface{

    @Autowired
    private UserRepository userRepo;

    @Override
    public Users registerUser(Users users) {
        return userRepo.save(users);
    }

    @Override
    public boolean UserIdExists(String generatedUserId) {
        return userRepo.existsByUserId(generatedUserId);  // Ensure this references the correct camelCase field
    }

}
