package com.ecommerce.EcommerceApplication.payload;


import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UserDto
{
    private int userId;
    @NotEmpty
    @Size(min=6,message = "User name must be min of 6 character")
    private String name;
    @NotEmpty

    private String phone;
    @Email(message = "Email Address is not valid ")
    private String email;
    @NotEmpty(message = "Password should not be blank")
    @Size(min=8,message = "password should be min of 8 character")
//    @Pattern(regexp = "[a-zA-Z0-9]")
    private String password;
}
