package com.ecommerce.EcommerceApplication.service.implementation;

import com.ecommerce.EcommerceApplication.exception.ResourceNotFoundException;
import com.ecommerce.EcommerceApplication.model.User;
import com.ecommerce.EcommerceApplication.payload.UserDto;
import com.ecommerce.EcommerceApplication.repository.UserRepository;
import com.ecommerce.EcommerceApplication.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation  implements UserService
{


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto)
    {
        User user=this.dtoToUser(userDto);
        User savedUser=this.userRepository.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId)
    {
        User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","userId",userId));
        user.setName(userDto.getName());
        user.setPhone(userDto.getPhone());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        User updatedUser=this.userRepository.save(user);
        UserDto userDto1=this.userToDto(updatedUser);

        return userDto1;

    }

    @Override
    public UserDto getUserById(Integer userId)
    {
        User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","userId",userId));

        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers()
    {
        List<User> users=this.userRepository.findAll();
       List<UserDto>userDtoList= users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());

        return userDtoList;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","userId",userId));

        this.userRepository.delete(user);

    }

    public User dtoToUser(UserDto userDto)
    {
       User user=this.modelMapper.map(userDto,User.class);
       return user;
    }

    public UserDto userToDto(User user)
    {
        UserDto userDto=this.modelMapper.map(user,UserDto.class);
        return userDto;
    }
}
