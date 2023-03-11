package com.example.ratingsservice.services;

import com.TrendingMoviesClientService.Rating;
import com.TrendingMoviesClientService.RatingList;
import com.example.ratingsservice.dao.DatabaseInstance;
import com.example.ratingsservice.models.UserRating;
import com.google.protobuf.Message;
import org.springframework.stereotype.Service;

import java.sql.Array;
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

    public List<Rating> getTrending() {
        String query = "SELECT movieId, AVG(rating) AS av FROM ratings GROUP BY movieId ORDER BY av DESC LIMIT 10";
        ArrayList<Rating> arrayList = new ArrayList<>();

        try {
            ResultSet resultSet = instance.executeQuery(query);
            while (resultSet.next()) {
                Rating r = new Rating().newBuilderForType().setMovieId(resultSet.getString("movieId")).setRating(resultSet.getFloat("av")).build();
                arrayList.add(r);
                System.out.println(r.getMovieId() + "  " + r.getRating());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
