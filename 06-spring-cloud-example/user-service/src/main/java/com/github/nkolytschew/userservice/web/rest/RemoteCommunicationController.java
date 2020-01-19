package com.github.nkolytschew.userservice.web.rest;


import com.github.nkolytschew.userservice.service.LegacyServiceClent;
import com.github.nkolytschew.userservice.service.RatingServiceHandler;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * To keep it simple, we combine the communication with the remote services in this controller.
 */
@RestController
public class RemoteCommunicationController {

    private final LegacyServiceClent legacyServiceClent;
    private final RatingServiceHandler ratingServiceHandler;

    public RemoteCommunicationController(LegacyServiceClent legacyServiceClent, RatingServiceHandler ratingServiceHandler) {
        this.legacyServiceClent = legacyServiceClent;
        this.ratingServiceHandler = ratingServiceHandler;
    }

    @GetMapping("/rating/{userId}")
    public String findRatingById(@PathVariable String userId) {
        return ratingServiceHandler.findRatingsByUser(userId);
    }

    @GetMapping("/legacy/{id}")
    public String findAnimalShelterById(@PathVariable Long id) {
        return this.legacyServiceClent.findAnimalShelterById(id);
    }

    @PostMapping("/legacy/{id}")
    public String createAnimalShelterRequest(@PathVariable Long id, @RequestBody Map<String, Object> body) {
        this.legacyServiceClent.sendRequestToAnimalShelter(id, body);

        return "200 - OK";
    }

    @PostMapping("/rating")
    public String createRating(@RequestBody Map<String, Object> body) {
        return this.ratingServiceHandler.createNewRating(body);
    }

    @DeleteMapping("/rating/{id}")
    public String deleteRating(@PathVariable String id) {
        return this.ratingServiceHandler.deleteRatingById(id);
    }

}
