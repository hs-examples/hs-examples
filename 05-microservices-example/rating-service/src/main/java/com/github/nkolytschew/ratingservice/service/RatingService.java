package com.github.nkolytschew.ratingservice.service;

import com.github.nkolytschew.ratingservice.web.model.RatingModel;

public interface RatingService {

    RatingModel findRatingsByUserId(String userId);

    RatingModel createRating(RatingModel model);

    RatingModel deleteRatingById(Long ratingId);
}
