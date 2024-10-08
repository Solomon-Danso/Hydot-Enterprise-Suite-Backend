package com.hydottech.HES_Backend.Repository;

import com.hydottech.HES_Backend.Entity.SecurityManager;
import com.hydottech.HES_Backend.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecurityManagerRepo extends JpaRepository<SecurityManager, Long> {
    SecurityManager findByUserId(String userId);
}
