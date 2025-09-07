package com.mojaru.project.repository;

import com.mojaru.project.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    // You can define custom query methods here if needed
    User getUserByEmail(String email);
}