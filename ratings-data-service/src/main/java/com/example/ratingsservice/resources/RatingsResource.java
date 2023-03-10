package com.example.ratingsservice.resources;

import com.example.ratingsservice.models.UserRating;
import com.example.ratingsservice.services.RatingService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/ratings")
public class RatingsResource {

    private RatingService ratingService;

    public RatingsResource(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @RequestMapping("/{userId}")
    public UserRating getRatingsOfUser(@PathVariable String userId) {

        return this.ratingService.getUserRating(userId);
    }
}
