package com.grepp.javatokotlinmytest.service;

import com.grepp.javatokotlinmytest.entity.User;
import com.grepp.javatokotlinmytest.repository.UserRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // C
    public User createUser(String name, String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);

        return userRepository.save(user);
    }

    // R
    public Optional<User> findUser(Long id){
        return userRepository.findById(id);
    }

    // U
    public User updateUser(Long id, String name){
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(name);

        return userRepository.save(user);
    }

//    @Transactional   // persistence context, JPA dirty checking, JPA flush, DB transaction commit
//    public User updateUserV2(Long id, String name){
//        User user = userRepository.findById(id)
//            .orElseThrow(() -> new RuntimeException("User not found"));
//
//        user.setName(name);
//
//        return user;
//    }
}
