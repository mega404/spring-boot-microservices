package com.moviecatalogservice.services;

import org.springframework.stereotype.Service;

import net.devh.boot.grpc.client.inject.GrpcClient;
import com.TrendingMoviesClientService.RatingList;
import com.TrendingMoviesClientService.TrendingMoviesIdsServiceGrpc;
import com.TrendingMoviesClientService.request;

@Service
public class TrendingMoviesService {

    @GrpcClient("serverName")
    private TrendingMoviesIdsServiceGrpc.TrendingMoviesIdsServiceBlockingStub myServiceStub;

    public RatingList getTrending(String req) {
        request r = request.newBuilder().setReqMessage("hello")
                .build();
        return myServiceStub.getTrendingMoviesIds(r).next();
    }
}