package com.hydottech.HES_Backend.Service;

import com.hydottech.HES_Backend.Entity.SecurityManager;

public interface SecurityManagerInterface {

    SecurityManager findSessionByUserId(String userId);

    void saveSession(SecurityManager existingSession);
}
