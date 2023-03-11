package com.TrendingMoviesClientService.services;

import com.TrendingMoviesClientService.RatingList;
import com.TrendingMoviesClientService.TrendingMoviesIdsServiceGrpc;
import com.TrendingMoviesClientService.request;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import static com.TrendingMoviesClientService.TrendingMoviesIdsServiceGrpc.newBlockingStub;

@Service
public class TrendingMoviesService {

    @GrpcClient("serverName")
    private TrendingMoviesIdsServiceGrpc.TrendingMoviesIdsServiceBlockingStub myServiceStub;

    public RatingList getTrending(request r) {
        return myServiceStub.getTrendingMoviesIds(r);
    }
}