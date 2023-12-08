package com.project.sahafproject.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sahafproject.entities.User;
import com.project.sahafproject.exception.UserNotFoundException;
import com.project.sahafproject.repos.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        // Check if the user exists before deleting
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
        } else {
            throw new UserNotFoundException("User not found with id: " + userId);
        }
    }

    public User updateUser(Long userId, User updatedUser) {
        // Check if the user exists before updating
        if (userRepository.existsById(userId)) {
        	updatedUser.setId(userId);
            updatedUser.setName(updatedUser.getName());
            return userRepository.save(updatedUser);
        } else {
            throw new UserNotFoundException("User not found with id: " + userId);
        }
    }
    
    public User createUser(String name) {
        User user = new User();
        user.setName(name);
        return userRepository.save(user);
    }

}
