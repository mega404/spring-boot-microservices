package com.example.ratingsservice.services;

import com.TrendingMoviesClientService.RatingList;
import com.example.ratingsservice.dao.DatabaseInstance;
import com.example.ratingsservice.models.Rating;
import com.example.ratingsservice.models.UserRating;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrendingService {


    private final DatabaseInstance instance;

    public TrendingService() throws SQLException {
        this.instance = DatabaseInstance.getInstance();
    }

    public RatingList getTrending() {
        String query = "SELECT movieId, AVG(rating) AS av FROM ratings GROUP BY movieId ORDER BY av DESC LIMIT 10";
        RatingList ratings = new RatingList();

        try {
            ResultSet resultSet = instance.executeQuery(query);
            System.out.println(resultSet);
            while (resultSet.next()) {
                Rating r = new Rating(resultSet.getString("movieId"), resultSet.getInt("av"));
//                ratings.newBuilderForType().addRatingList(r);
                System.out.println(r.getMovieId() + "  " + r.getRating());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(ratings);
        return ratings;
    }
}
