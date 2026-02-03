package com.rauulssanchezz.authadminstarter.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("ROLE_USER");
        }

        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public long getCount() {
        return userRepository.count();
    }

    public void delete(long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty() || user == null) {
            throw new RuntimeException("User does not exist or not found.");
        }

        userRepository.deleteById(id);
    }

}
