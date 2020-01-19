package com.github.nkolytschew.ratingservice.web.model;


public class RatingModel {
    private String userId;
    private String comment;
    private int rating;

    public RatingModel() {
    }

    public RatingModel(String userId, String comment, int rating) {
        this.userId = userId;
        this.comment = comment;
        this.rating = rating;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
