package com.example.ratingsservice.services;

import com.example.ratingsservice.dao.DatabaseInstance;
import com.example.ratingsservice.models.Rating;
import com.example.ratingsservice.models.UserRating;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RatingService {
    private final DatabaseInstance instance;

    public RatingService() throws SQLException {
        this.instance = DatabaseInstance.getInstance();
    }

    public UserRating getUserRating(String userId) {
        String query = "SELECT * from ratings as r WHERE r.userId = '" + userId + "'";
        List<Rating> ratings = new ArrayList<>();
        try {
            ResultSet resultSet = instance.executeQuery(query);
            while (resultSet.next()) {
                ratings.add(new Rating(resultSet.getString("movieId"), resultSet.getInt("rating")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(ratings);
        return new UserRating(ratings);
    }
}
