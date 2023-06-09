package com.moviecatalogservice.resources;

import com.TrendingMoviesClientService.RatingList;
import com.moviecatalogservice.models.CatalogItem;
import com.moviecatalogservice.models.Rating;
import com.moviecatalogservice.services.MovieInfoService;
import com.moviecatalogservice.services.TrendingMoviesService;
import com.moviecatalogservice.services.UserRatingService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    private final RestTemplate restTemplate;

    private final MovieInfoService movieInfoService;

    private final TrendingMoviesService trendingMoviesService;

    private final UserRatingService userRatingService;

    public MovieCatalogResource(RestTemplate restTemplate,
                                MovieInfoService movieInfoService,
                                TrendingMoviesService trendingMoviesService, UserRatingService userRatingService) {

        this.restTemplate = restTemplate;
        this.movieInfoService = movieInfoService;
        this.trendingMoviesService = trendingMoviesService;
        this.userRatingService = userRatingService;
    }

    /**
     * Makes a call to MovieInfoService to get movieId, name and description,
     * Makes a call to RatingsService to get ratings
     * Accumulates both data to create a MovieCatalog
     *
     * @param userId
     * @return CatalogItem that contains name, description and rating
     */
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId) {
        List<Rating> ratings = userRatingService.getUserRating(userId).getRatings();
        return ratings.stream().map(movieInfoService::getCatalogItem).collect(Collectors.toList());
    }

    @RequestMapping("/trending")
    public List<CatalogItem> TrendingMovies() {
        RatingList ratingList = trendingMoviesService.getTrending();
        System.out.println(ratingList.toString());
        List<Rating> ratings = toRating(ratingList.getRatingListList());
        return ratings.stream().map(movieInfoService::getCatalogItem).collect(Collectors.toList());
    }

    private List<Rating> toRating(List<com.TrendingMoviesClientService.Rating> ratingListList) {
        List<Rating> list = new ArrayList<>();
        for (com.TrendingMoviesClientService.Rating item : ratingListList) {
            list.add(new Rating(item.getMovieId(), item.getRating()));
        }
        return list;
    }

}
