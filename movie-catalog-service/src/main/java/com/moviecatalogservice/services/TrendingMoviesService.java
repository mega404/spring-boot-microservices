package com.moviecatalogservice.services;

import com.TrendingMoviesClientService.Rating;
import com.TrendingMoviesClientService.RatingList;
import org.springframework.stereotype.Service;

import net.devh.boot.grpc.client.inject.GrpcClient;
import com.TrendingMoviesClientService.TrendingMoviesIdsServiceGrpc;
import com.TrendingMoviesClientService.request;

@Service
public class TrendingMoviesService {

    @GrpcClient("serverName")
    private TrendingMoviesIdsServiceGrpc.TrendingMoviesIdsServiceBlockingStub myServiceStub;

    public RatingList getTrending() {
        request r = request.newBuilder().build();
        return myServiceStub.getTrendingMoviesIds(r);
    }
}