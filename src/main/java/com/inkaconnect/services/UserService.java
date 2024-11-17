package com.inkaconnect.services;

import com.inkaconnect.exceptions.UserAlreadyExistsException;
import com.inkaconnect.exceptions.UserNotFoundException;
import com.inkaconnect.models.User;
import com.inkaconnect.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new UserAlreadyExistsException("Email already in use");
        }
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    public boolean existsById(String authorId) {
        return userRepository.existsById(authorId);
    }

    public User authenticate(String email, String password) {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email));
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user.get();
        }
        return null;
    }
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    public User updateUser(String id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setAvatarBase64(userDetails.getAvatarBase64());
        user.setBio(userDetails.getBio());
        user.setLocation(userDetails.getLocation());
        user.setAddress(userDetails.getAddress());
        user.setPhone(userDetails.getPhone());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        return userRepository.save(user);
    }

}
