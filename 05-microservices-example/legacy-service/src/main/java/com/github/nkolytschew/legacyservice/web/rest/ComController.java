package com.github.nkolytschew.legacyservice.web.rest;


import com.github.nkolytschew.legacyservice.web.model.ComModel;
import org.springframework.web.bind.annotation.*;


/**
 * Simplified. Just return a simple String.
 */
@RequestMapping("api/v1")
@RestController
public class ComController {

    @GetMapping("shelter/{id}")
    public String findAnimalShelterById(@PathVariable Long id) {
        return "200 - OK";
    }

    @PostMapping("shelter/{id]")
    public String sendRequestToAnimalShelter(@PathVariable Long id,
                                             @RequestBody ComModel model) {
        return "200 - OK";
    }
}
