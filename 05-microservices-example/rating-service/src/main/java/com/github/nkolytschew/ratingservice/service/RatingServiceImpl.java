package com.github.nkolytschew.ratingservice.service;

import com.github.nkolytschew.ratingservice.mongodb.document.RatingDocument;
import com.github.nkolytschew.ratingservice.mongodb.repository.RatingRepository;
import com.github.nkolytschew.ratingservice.web.model.RatingModel;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {
    private final RatingRepository repository;

    public RatingServiceImpl(RatingRepository repository) {
        this.repository = repository;
    }

    @Override
    public RatingModel findRatingsByUserId(String userId) {
        final RatingDocument doc = repository.findByUserId(userId);
        final RatingModel model = new RatingModel();
        model.setComment(doc.getComment());
        model.setRating(doc.getRating());
        model.setUserId(doc.getUserId());

        return model;
    }

    @Override
    public void createRating(RatingModel model) {
        final RatingDocument doc = new RatingDocument();
        doc.setComment(model.getComment());
        doc.setRating(model.getRating());
        doc.setUserId(model.getUserId());
        this.repository.save(doc);
    }

    @Override
    public RatingModel deleteRatingById(Long id) {
        final RatingModel model = new RatingModel();
        repository.findById(id).ifPresent(doc -> {
            model.setComment(doc.getComment());
            model.setRating(doc.getRating());
            model.setUserId(doc.getUserId());
        });
        repository.deleteById(id);

        return model;
    }
}
