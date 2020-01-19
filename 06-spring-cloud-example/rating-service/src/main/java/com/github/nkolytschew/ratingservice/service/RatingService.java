package com.github.nkolytschew.ratingservice.service;

import com.github.nkolytschew.ratingservice.web.model.RatingModel;

import java.util.List;

public interface RatingService {

    List<RatingModel> findRatingsByUserId(String userId);

    void createRating(RatingModel model);

    RatingModel deleteRatingById(String ratingId);
}
