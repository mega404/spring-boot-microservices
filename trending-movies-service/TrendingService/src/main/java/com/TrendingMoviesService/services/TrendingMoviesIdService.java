package com.TrendingMoviesService.services;

import com.TrendingMoviesService.RatingList;
import com.TrendingMoviesService.TrendingMoviesIdsServiceGrpc;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;

public class TrendingMoviesIdService extends TrendingMoviesIdsServiceGrpc.TrendingMoviesIdsServiceImplBase {

    @Override
    public void getTrendingMoviesIds(Empty request, StreamObserver<RatingList> responseObserver) {
        super.getTrendingMoviesIds(request, responseObserver);
    }
}
