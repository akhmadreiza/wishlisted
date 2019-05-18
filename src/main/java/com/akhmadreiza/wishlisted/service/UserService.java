package com.akhmadreiza.wishlisted.service;

import com.akhmadreiza.wishlisted.apis.UserDto;
import com.akhmadreiza.wishlisted.entity.User;

import java.util.List;

public interface UserService {
    User save(UserDto userDto);

    List<User> findAll();

    void delete(String id);

    User findOne(String userName);

    User findById(String id);
}
