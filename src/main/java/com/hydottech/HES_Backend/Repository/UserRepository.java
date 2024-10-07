package com.hydottech.HES_Backend.Repository;

import com.hydottech.HES_Backend.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    boolean existsByUserId(String userId);  // Change parameter to camelCase
    Optional<Users> findByUserId(String userId);

    void deleteByUserId(String userId);

    boolean existsByPrimaryRole(String superAdmin);
}
