package com.alex.carmanagement.service;

import com.alex.carmanagement.converter.UserConverter;
import com.alex.carmanagement.datamodel.User;
import com.alex.carmanagement.dto.UserDto;
import com.alex.carmanagement.exceptions.MyException;
import com.alex.carmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User createUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            String msg = "Please try again";
            throw new MyException(String.format("User with username %s not found %s", username, msg));
        }
        return user;
    }

    public List<UserDto> findAll(Integer page, Integer size) {
        List<UserDto> users = new ArrayList<>();

        List<User> dbUsers = userRepository.findAll(PageRequest.of(page, size)).getContent();
        for (User user : dbUsers) {
            users.add(UserConverter.convert(user));
        }
        return users;

    }

    public User findById(Integer id) {
        Optional<User> byId = userRepository.findById(id);
        User usertemp = byId.get();
        return usertemp;
    }

    public User updateUser(Integer id, User user) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            User usertemp = byId.get();
            usertemp.setFirstName(user.getFirstName());
            usertemp.setLastName(user.getLastName());
            usertemp.setPassword(user.getPassword());
            return userRepository.save(usertemp);
        } else {
            throw new MyException("No such user");
        }
    }

    public void deleteUser(Integer id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new MyException("Impossible to delete. No such user");
        }
    }
}
