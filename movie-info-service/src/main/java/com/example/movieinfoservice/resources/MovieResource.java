package com.example.movieinfoservice.resources;

import com.example.movieinfoservice.models.Movie;
import com.example.movieinfoservice.models.MovieSummary;
import com.example.movieinfoservice.mongoDB.ItemRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Value("${api.key}")
    private String apiKey;

    private ItemRepository itemRepository;

    private RestTemplate restTemplate;

    public MovieResource(ItemRepository itemRepository, RestTemplate restTemplate) {
        this.itemRepository = itemRepository;
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
        Optional<MovieSummary> res = itemRepository.findById(movieId);
        MovieSummary movieSummary;
        if (res.isPresent()) {
            movieSummary = res.get();
            System.out.println("cache hit");
        } else {
            System.out.println("cache miss");
            final String url = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey;
            movieSummary = restTemplate.getForObject(url, MovieSummary.class);
            if (movieSummary != null)
                itemRepository.save(movieSummary);

        }
        return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
    }
}
