package com.akhmadreiza.wishlisted.service;

import com.akhmadreiza.wishlisted.apis.UserDto;
import com.akhmadreiza.wishlisted.entity.User;
import com.akhmadreiza.wishlisted.repository.UserRepository;
import com.ara27.arautil.general.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authorities;
    }

    @Override
    public User save(UserDto userDto) {
        GeneralUtil generalUtil = new GeneralUtil();
        User newUser = new User();
        newUser.setId(generalUtil.getUUID());
        newUser.setUserName(userDto.getUserName());
        newUser.setPassword(bcryptEncoder.encode(userDto.getPassword()));
        newUser.setCreatedDate(generalUtil.getCurrentLocalDateTime());
        return userRepository.save(newUser);
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findOne(String userName) {
        return userRepository.findUserByUserName(userName);
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).get();
    }
}
