package com.hydottech.Hydot.Enterprise.Suite.Backend.repository;

import com.hydottech.Hydot.Enterprise.Suite.Backend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {


}
