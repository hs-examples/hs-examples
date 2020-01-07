package com.github.nkolytschew.userservicems.a2.mysql.jpa.repository;


import com.github.nkolytschew.userservicems.jpa.entity.Address;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("!h2")
public interface AddressRepository extends CrudRepository<Address, Long> {
}
