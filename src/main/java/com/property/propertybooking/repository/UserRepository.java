package com.property.propertybooking.repository;

import com.property.propertybooking.entity.Role;
import com.property.propertybooking.entity.User;

import org.springframework.boot.data.autoconfigure.web.DataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    
    
    
    

    // Filter users by role (pagination)
    Page<User> findByRole(Role role, PageRequest pageable);

    
    
	// Search users by name (pagination)
	Page<User> findByNameContainingIgnoreCase(String search, PageRequest pageable);
}
