package com.project.sahafproject.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.sahafproject.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}	
