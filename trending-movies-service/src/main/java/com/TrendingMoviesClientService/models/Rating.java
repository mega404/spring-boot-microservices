package com.TrendingMoviesClientService.models;

public class Rating {

    private String movieId;
    private float rating;

    public Rating() {
    }

    public Rating(String movieId, float rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
