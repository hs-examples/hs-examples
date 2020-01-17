package com.github.nkolytschew.userservice.service;

import java.util.Map;

public interface LegacyServiceHandler {
    void sendRequest(Long id, Map<String, Object> requestBodyAsJson);

    String getAnimalShelter(Long id);
}
