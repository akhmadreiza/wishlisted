package com.akhmadreiza.wishlisted.repository;

import com.akhmadreiza.wishlisted.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findUserByUserName(String userName);
}
