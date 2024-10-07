package com.hydottech.HES_Backend.Service;

import com.hydottech.HES_Backend.Entity.Users;

import java.util.List;

public interface UserServiceInterface {
    Users registerUser(Users users);

    boolean UserIdExists(String generatedUserId);

    Users getUserById(String userId);

    Users updateUser(Users existingUser);

    List<Users> getAllUsers();

    void deleteUser(String userId);


    boolean superAdminExists();
}
