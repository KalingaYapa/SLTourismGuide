package com.project.sltourguide.repository;

import com.project.sltourguide.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
