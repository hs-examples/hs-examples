package com.example.springdatademo.jpa.repository;

import com.example.springdatademo.jpa.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
