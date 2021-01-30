package com.gadgetmart.gadgetmart.repository;

import com.gadgetmart.gadgetmart.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findUserByUserId(String userId);
}
