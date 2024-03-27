package com.springbootproject.content.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootproject.content.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	boolean existsByEmail(String email);
	
	 Optional<User> findByEmail(String email);

}
