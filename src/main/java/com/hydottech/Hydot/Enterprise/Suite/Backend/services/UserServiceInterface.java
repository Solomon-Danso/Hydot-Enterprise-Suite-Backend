package com.hydottech.Hydot.Enterprise.Suite.Backend.services;

import com.hydottech.Hydot.Enterprise.Suite.Backend.entity.UserEntity;
import com.hydottech.Hydot.Enterprise.Suite.Backend.model.UserModel;

public interface UserServiceInterface {
    UserEntity registerUser(UserModel userModel);
}
