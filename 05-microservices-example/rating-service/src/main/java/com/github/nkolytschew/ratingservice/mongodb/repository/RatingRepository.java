package com.github.nkolytschew.ratingservice.mongodb.repository;


import com.github.nkolytschew.ratingservice.mongodb.document.RatingDocument;
import com.github.nkolytschew.ratingservice.web.model.RatingModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RatingRepository extends MongoRepository<RatingDocument, String> {
    RatingDocument findByUserId(String userId);
}
