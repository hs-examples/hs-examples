package com.github.nkolytschew.userservice.service;

public interface RatingServiceHandler {

    String findRatingsByUser(String userId);

    String createNewRating(String ratingAsJson);

    String deleteRatingById(Long id);
}
