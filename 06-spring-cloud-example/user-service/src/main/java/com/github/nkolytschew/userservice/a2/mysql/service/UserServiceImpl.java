package com.github.nkolytschew.userservice.a2.mysql.service;

import com.github.nkolytschew.userservice.a2.mysql.jpa.repository.UserRepository;
import com.github.nkolytschew.userservice.a2.mysql.web.model.UserModel;
import com.github.nkolytschew.userservice.jpa.entity.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("!h2")
@Service
public class UserServiceImpl implements UserService {

    private final MappingService<User, UserModel> mapper;

    private final UserRepository repository;

    public UserServiceImpl(MappingService mapper, UserRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public UserModel getUser(Long id) {
        final var user = this.mapper.mapToModel(
                this.repository.findById(id).get());
        return user;
    }

    @Override
    public UserModel saveUser(UserModel model) {
        final var user = this.mapper.mapToModel(
                this.repository.save(this.mapper.mapToEntity(model)));
        return user;
    }

    @Override
    public UserModel updateUser(Long id, UserModel body) {
        final var entity = this.repository.findById(id).get();
        final var user = this.mapper.mapToModel(
                this.repository.save(this.mapper.mapToEntity(entity, body)));
        return user;
    }

    @Override
    public UserModel deleteUser(Long id) {
        final var user = this.mapper.mapToModel(
                this.repository.findById(id).get());
        this.repository.deleteById(id);
        return user;
    }
}
