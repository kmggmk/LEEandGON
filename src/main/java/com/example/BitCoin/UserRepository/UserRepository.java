package com.example.BitCoin.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BitCoin.Entity.User;

public interface UserRepository extends JpaRepository<User, String> {
	
}