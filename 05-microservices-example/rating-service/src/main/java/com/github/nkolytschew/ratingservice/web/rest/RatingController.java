package com.github.nkolytschew.ratingservice.web.rest;


import com.github.nkolytschew.ratingservice.service.RatingService;
import com.github.nkolytschew.ratingservice.web.model.RatingModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RatingController {

    private RatingService service;

    public RatingController(RatingService service) {
        this.service = service;
    }

    @GetMapping("rating/{userId}")
    public RatingModel findRatingByUserId(@PathVariable String userId) {
        return this.service.findRatingsByUserId(userId);
    }

    @DeleteMapping("rating/{id}")
    public RatingModel deleteRatingById(@PathVariable Long id) {
        return this.service.deleteRatingById(id);
    }
}
