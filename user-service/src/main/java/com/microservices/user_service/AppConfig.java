package com.microservices.user_service;

import com.microservices.user_service.user.DTOs.UserRequestDTO;
import com.microservices.user_service.user.DTOs.UserResponseDTO;
import com.microservices.user_service.user.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        modelMapper.typeMap(UserRequestDTO.class, User.class);
        modelMapper.typeMap(User.class, UserResponseDTO.class);


        return modelMapper;
    }
}
