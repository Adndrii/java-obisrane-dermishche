package com.microservices.user_service.user;

import com.microservices.user_service.user.DTOs.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    private final ModelMapper modelMapper;

    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserResponseDTO.class))
                .collect(Collectors.toList());
    }

    public UserResponseDTO getUser(Integer id) {
        User user = userRepository.getById(id);
        return modelMapper.map(user, UserResponseDTO.class);
    }

    public User addUser(UserRequestDTO userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        return userRepository.save(user);
    }

    public void updateUser(Integer id, UserRequestDTO userRequest) {
        User existingUser = userRepository.getById(id);
        modelMapper.map(userRequest, existingUser); // Update fields in the existing user
        userRepository.save(existingUser);         // Save the updated user
    }

    public void deleteUser(Integer id) {
        var user = userRepository.getById(id);
        userRepository.delete(user);
    }

}
