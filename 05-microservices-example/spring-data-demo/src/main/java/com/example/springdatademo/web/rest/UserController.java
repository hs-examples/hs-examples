package com.example.springdatademo.web.rest;

import com.example.springdatademo.jpa.entity.User;
import com.example.springdatademo.jpa.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api")
public class UserController {

    private UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("user/{user_id}")
    public User findUserById(@PathVariable(name = "user_id") Long id) {
        return repository.findById(id).get();
    }

    @PostMapping("user")
    public User createUser(@RequestBody User user) {
        return repository.save(user);
    }

    @PutMapping("user/{id}")
    public User updateUserbyId(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return repository.save(user);
    }

    @DeleteMapping("user/{user_id}")
    public int deleteUserById(@PathVariable(name = "user_id") Long id) {
        repository.deleteById(id);
        return 200;
    }

    // i bin ein cheater
    @GetMapping("createMeHard")
    public int createRandomUsers() {
        for (int i = 0; i < 10; i++) {
            final User random = new User();
            random.setFullName(UUID.randomUUID().toString());

            repository.save(random);
        }
        return 200;
    }
}
