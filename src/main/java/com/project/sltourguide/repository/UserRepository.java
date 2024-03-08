package com.project.sltourguide.repository;

import com.project.sltourguide.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
