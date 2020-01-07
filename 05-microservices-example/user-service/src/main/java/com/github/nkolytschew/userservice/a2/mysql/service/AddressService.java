package com.github.nkolytschew.userservicems.a2.mysql.service;


import com.github.nkolytschew.userservicems.a2.mysql.web.model.AddressModel;

public interface AddressService {

    AddressModel getAddress(Long id);

    AddressModel saveAddress(AddressModel body);

    AddressModel updateAddress(Long id, AddressModel body);

    AddressModel deleteAddress(Long id);
}
