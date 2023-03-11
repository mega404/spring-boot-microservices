package com.example.ratingsservice.resources;

import com.TrendingMoviesClientService.Rating;
import com.TrendingMoviesClientService.RatingList;
import com.TrendingMoviesClientService.TrendingMoviesIdsServiceGrpc;
import com.TrendingMoviesClientService.request;
import com.example.ratingsservice.services.TrendingService;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.ArrayList;

@GrpcService
public class TrendingMoviesResource extends TrendingMoviesIdsServiceGrpc.TrendingMoviesIdsServiceImplBase {

    private final TrendingService trendingService;

    public TrendingMoviesResource(TrendingService trendingService) {
        this.trendingService = trendingService;
    }

    @Override
    public void getTrendingMoviesIds(request request, io.grpc.stub.StreamObserver<RatingList> responseObserver) {
        System.out.println("Rating Service received request from trending");
        ArrayList<Rating> ratings = (ArrayList<Rating>) this.trendingService.getTrending();
        RatingList.Builder reply = RatingList.newBuilder().addAllRatingList(ratings);
        responseObserver.onNext(reply.build());
        responseObserver.onCompleted();
    }
}
