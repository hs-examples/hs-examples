package com.github.nkolytschew.ratingservice.web.rest;


import com.github.nkolytschew.ratingservice.service.RatingService;
import com.github.nkolytschew.ratingservice.web.model.RatingModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RatingController {

    private RatingService service;

    public RatingController(RatingService service) {
        this.service = service;
    }

    @GetMapping("rating/{userId}")
    public List<RatingModel> findRatingByUserId(@PathVariable String userId) {
        return this.service.findRatingsByUserId(userId);
    }

    @PostMapping("rating")
    public String createRating(@RequestBody RatingModel model) {
        this.service.createRating(model);

        return "200 - OK";
    }

    @DeleteMapping("rating/{id}")
    public RatingModel deleteRatingById(@PathVariable Long id) {
        return this.service.deleteRatingById(id.toString());
    }
}
