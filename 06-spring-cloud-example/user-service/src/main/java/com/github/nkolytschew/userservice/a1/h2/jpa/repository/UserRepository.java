package com.github.nkolytschew.userservice.a1.h2.jpa.repository;


import com.github.nkolytschew.userservice.jpa.entity.User;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Profile("h2")
@RepositoryRestResource(path = "user")
public interface UserRepository extends CrudRepository<User, Long> {
}

