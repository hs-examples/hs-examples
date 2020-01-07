package com.github.nkolytschew.userservice.service;

public interface LegacyServiceHandler {
    void sendRequest(Long id, String requestBodyAsJson);

    String getAnimalShelter(Long id);
}
