package com.ecommerce.EcommerceApplication.controller;

import com.ecommerce.EcommerceApplication.payload.ApiResponse;
import com.ecommerce.EcommerceApplication.payload.UserDto;
import com.ecommerce.EcommerceApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController
{
    @Autowired
    private UserService userService;


    //create User
    @PostMapping("/")
    public ResponseEntity<UserDto> createNewUser(@Valid @RequestBody UserDto userDto)
    {
        UserDto createdUserDto=this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("userId") Integer userId)
    {
        UserDto updatedUserDto=this.userService.updateUser(userDto,userId);
        return ResponseEntity.ok(updatedUserDto);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer userId)
    {
        this.userService.deleteUser(userId);

        return new ResponseEntity(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Integer userId)
    {
        return ResponseEntity.ok(this.userService.getUserById(userId));

    }

    @GetMapping("/")

    public ResponseEntity<List<UserDto>> getAllUsers()
    {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }
}
