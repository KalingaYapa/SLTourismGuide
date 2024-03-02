package com.project.sltourguide.service;

import com.project.sltourguide.entity.User;
import com.project.sltourguide.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<User> getUsers() {
       return userRepository.findAll();
    }
}
