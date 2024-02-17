package com.project.sltourguide.repository;

import com.project.sltourguide.entity.SLTourUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SLTourUser, Integer> {

}
