package com.mojaru.project.service;

import com.mojaru.project.model.User;
import com.mojaru.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User registerUser(User userFromRequest) {


        String normalizedEmail = normalizeEmail(userFromRequest.getEmail());


        if (userRepository.existsByEmailIgnoreCase(normalizedEmail)) {
            throw new RuntimeException("Email Address already exists. A new account cannot be created.");
        }

        User userToSave = new User();

        userToSave.setEmail(normalizedEmail);

        userToSave.setPassword(passwordEncoder.encode(userFromRequest.getPassword()));

        userToSave.setName(userFromRequest.getName());

        return userRepository.save(userToSave);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }


    private String normalizeEmail(String email) {
        return email == null ? null : email.trim().toLowerCase();
    }
}