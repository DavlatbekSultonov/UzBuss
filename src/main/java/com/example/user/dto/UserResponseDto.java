package com.example.user.dto;

import com.example.user.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponseDto {
    private Integer id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private Role userType;
    private String password;
    private String cardNumber;
    private Integer balanse;
}
