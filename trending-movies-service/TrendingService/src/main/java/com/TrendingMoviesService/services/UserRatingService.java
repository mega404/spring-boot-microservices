package com.TrendingMoviesService.services;

import com.moviecatalogservice.models.Rating;
import com.moviecatalogservice.models.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Objects;

@Service
public class UserRatingService {

    private final RestTemplate restTemplate;

    public UserRatingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @HystrixCommand(fallbackMethod = "getFallbackUserRatings",
            threadPoolKey = "ratingPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),  // Size of thread pool
                    @HystrixProperty(name = "maxQueueSize", value = "10")   // Waiting in thread queue
            },
            commandProperties = {
                    // Time to cause timeout
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    // N, Hystrix looks at (analyzes) last N requests.
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    // if >= 50 percent of the last N requests fail, break the circuit
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    // Wait/Sleep for 5 seconds before sending another request to the failed service
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            })


    public UserRating getTrendingMoviesId() {
        String trendingUrl = "http://ratings-data-service/ratings/trending/;"
        return Objects.requireNonNull(restTemplate.getForObject(trendingUrl, Rating.class));
    }

    public UserRating getFallbackTrendingMoviesId() {
        UserRating userRating = new UserRating();
        userRating.setUserId(userId);
        userRating.setRatings(Collections.singletonList(
                new Rating("0", 0)
        ));

        return userRating;
    }
}
