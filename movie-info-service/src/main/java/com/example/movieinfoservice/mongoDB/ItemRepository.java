package com.example.movieinfoservice.mongoDB;

import com.example.movieinfoservice.models.Movie;
import com.example.movieinfoservice.models.MovieSummary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ItemRepository extends MongoRepository<MovieSummary, String> {

}