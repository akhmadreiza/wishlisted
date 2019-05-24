package com.akhmadreiza.wishlisted.endpoint;

import com.akhmadreiza.wishlisted.apis.UserDto;
import com.akhmadreiza.wishlisted.entity.User;
import com.akhmadreiza.wishlisted.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserEndpoint {
    @Autowired
    private UserService userService;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getOne(@PathVariable(value = "id") String id) {
        return userService.findById(id);
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public User saveUser(@RequestBody UserDto user) {
        return userService.save(user);
    }
}
