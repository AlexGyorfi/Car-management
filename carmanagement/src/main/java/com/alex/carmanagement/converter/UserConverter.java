package com.alex.carmanagement.converter;

import com.alex.carmanagement.datamodel.User;
import com.alex.carmanagement.dto.UserDto;

public class UserConverter {
    public static UserDto convert(User user) {
        UserDto userDto = new UserDto();
        userDto.setFirstName((user.getFirstName()));
        userDto.setLastName((user.getLastName()));
        userDto.setId((user.getUserId()));
        userDto.setUsername(user.getUsername());
        userDto.setPassword("*****");
        return userDto;
    }
    public static User convertBack(UserDto userDto) {
        User user = new User();
        user.setFirstName((userDto.getFirstName()));
        user.setLastName((userDto.getLastName()));
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        return user;
    }
}
