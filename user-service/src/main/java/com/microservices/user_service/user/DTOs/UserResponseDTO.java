package com.microservices.user_service.user.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private int id;
    private String username;
    private String email;
    private Date created_at;
    private String first_name;
    private String last_name;
    private String gender;
    private String address;
    private String phone;
}