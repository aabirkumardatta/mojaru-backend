package com.mojaru.project.service;

import com.mojaru.project.model.User;
import com.mojaru.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User registerUser(User userFromRequest) {

        User userFromDatabase = userRepository.getUserByEmail(userFromRequest.getEmail());
        if (!ObjectUtils.isEmpty(userFromDatabase)) {
            throw new RuntimeException("Email Address already exists. A new account cannot be created.");
        }

        User userToSave = new User();
        userToSave.setEmail(userFromRequest.getEmail());
        userToSave.setPassword(passwordEncoder.encode(userFromRequest.getPassword()));
        userToSave.setUsername(userFromRequest.getUsername());

        return userRepository.save(userToSave);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}