package com.github.nkolytschew.userservice.service;

import java.util.Map;

public interface RatingServiceHandler {

    String findRatingsByUser(String userId);

    String createNewRating(Map<String, Object> ratingAsJson);

    String deleteRatingById(String id);
}
