package com.example.user.dto;

import com.example.user.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCreateDto {
    private String name;
    private String surname;
    private String phoneNumber;
    private Role userType;
    private String email;
    private String password;

}
