package com.github.nkolytschew.userservicems.a2.mysql.service;

import com.github.nkolytschew.userservicems.a2.mysql.jpa.repository.AddressRepository;
import com.github.nkolytschew.userservicems.a2.mysql.web.model.AddressModel;
import com.github.nkolytschew.userservicems.jpa.entity.Address;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("!h2")
@Service
public class AddressServiceImpl implements AddressService {

    private final MappingService<Address, AddressModel> mapper;
    private final AddressRepository repository;

    public AddressServiceImpl(MappingService mapper, AddressRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public AddressModel getAddress(Long id) {
        final var address = this.mapper.mapToModel(
                this.repository.findById(id).get());
        return address;
    }

    @Override
    public AddressModel saveAddress(AddressModel body) {
        final var address = this.mapper.mapToModel(
                this.repository.save(this.mapper.mapToEntity(body)));
        return address;
    }

    @Override
    public AddressModel updateAddress(Long id, AddressModel body) {
        final var entity = this.repository.findById(id).get();
        final var address = this.mapper.mapToModel(
                this.repository.save(this.mapper.mapToEntity(entity, body)));
        return address;
    }

    @Override
    public AddressModel deleteAddress(Long id) {
        final var address = this.mapper.mapToModel(
                this.repository.findById(id).get());
        this.repository.deleteById(id);
        return address;
    }
}
