package com.movietrendingservice.services;

import com.TrendingMoviesClientService.RatingList;
import com.TrendingMoviesClientService.TrendingMoviesIdsServiceGrpc;
import com.TrendingMoviesClientService.request;
import org.springframework.stereotype.Service;

@Service
public class TrendingMoviesService extends TrendingMoviesIdsServiceGrpc.TrendingMoviesIdsServiceImplBase {

    @Override
    public void getTrendingMoviesIds(request request, io.grpc.stub.StreamObserver<RatingList> responseObserver) {

    }
}
