package com.codewithproject.fullstackbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithproject.fullstackbackend.Entity.User;

public interface UserReopsitory extends JpaRepository<User, Long> {
    
}
