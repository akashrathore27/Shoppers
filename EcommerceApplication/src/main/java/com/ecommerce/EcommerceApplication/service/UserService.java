package com.ecommerce.EcommerceApplication.service;

import com.ecommerce.EcommerceApplication.model.User;
import com.ecommerce.EcommerceApplication.payload.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto,Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);

}
