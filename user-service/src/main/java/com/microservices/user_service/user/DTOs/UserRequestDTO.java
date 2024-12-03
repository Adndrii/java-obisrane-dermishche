package com.microservices.user_service.user.DTOs;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
    private String username;
    private String email;
    private String first_name;
    private String last_name;
    private String gender;
    private String address;
    private String phone;
}
