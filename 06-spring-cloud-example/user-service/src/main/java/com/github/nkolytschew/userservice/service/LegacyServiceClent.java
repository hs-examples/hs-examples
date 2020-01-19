package com.github.nkolytschew.userservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1")
@FeignClient("legacy-service")
public interface LegacyServiceClent {

    @GetMapping("shelter/{id}")
    public String findAnimalShelterById(@PathVariable Long id);

    @PostMapping("shelter/{id}")
    public String sendRequestToAnimalShelter(@PathVariable Long id,
                                             @RequestBody Object model);
}
