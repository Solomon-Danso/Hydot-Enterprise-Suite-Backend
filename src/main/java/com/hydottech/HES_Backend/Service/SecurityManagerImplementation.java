package com.hydottech.HES_Backend.Service;

import com.hydottech.HES_Backend.Entity.SecurityManager;
import com.hydottech.HES_Backend.Repository.SecurityManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityManagerImplementation implements  SecurityManagerInterface{

    @Autowired
    private SecurityManagerRepo securityManagerRepo;


    @Override
    public SecurityManager findSessionByUserId(String userId) {
        return securityManagerRepo.findByUserId(userId);
    }

    @Override
    public void saveSession(SecurityManager existingSession) {
        securityManagerRepo.save(existingSession);
    }
}
