package com.github.nkolytschew.userservice.web.rest;


import com.github.nkolytschew.userservice.service.LegacyServiceHandler;
import com.github.nkolytschew.userservice.service.RatingServiceHandler;
import org.springframework.web.bind.annotation.*;


/**
 * To keep it simple, we combine the communication with the remote services in this controller.
 */
@RestController
public class RemoteCommunicationController {

    private final LegacyServiceHandler legacyServiceHandler;
    private final RatingServiceHandler ratingServiceHandler;

    public RemoteCommunicationController(LegacyServiceHandler legacyServiceHandler, RatingServiceHandler ratingServiceHandler) {
        this.legacyServiceHandler = legacyServiceHandler;
        this.ratingServiceHandler = ratingServiceHandler;
    }

    @GetMapping("/rating/{userId}")
    public String findRatingById(@PathVariable String userId) {
        return ratingServiceHandler.findRatingsByUser(userId);
    }

    @GetMapping("/legacy/{id}")
    public String findAnimalShelterById(@PathVariable Long id) {
        return this.legacyServiceHandler.getAnimalShelter(id);
    }

    @PostMapping("/legacy/{id}")
    public String createAnimalShelterRequest(@PathVariable Long id, @RequestBody String body) {
        this.legacyServiceHandler.sendRequest(id, body);

        return "200 - OK";
    }

    @PostMapping("/rating")
    public String createRating(@RequestBody Map<String, Object> body) {
        return this.ratingServiceHandler.createNewRating(body);
    }

    @DeleteMapping("/rating/{id}")
    public String deleteRating(@PathVariable Long id) {
        return this.ratingServiceHandler.deleteRatingById(id);
    }

}
