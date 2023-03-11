package com.TrendingMoviesClientService.resources;

import com.TrendingMoviesClientService.Rating;
import com.TrendingMoviesClientService.RatingList;
import com.TrendingMoviesClientService.TrendingMoviesIdsServiceGrpc;
import com.TrendingMoviesClientService.request;
import com.TrendingMoviesClientService.services.TrendingMoviesService;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class TrendingMoviesIdsService extends TrendingMoviesIdsServiceGrpc.TrendingMoviesIdsServiceImplBase {

    private TrendingMoviesService trendingMoviesService;

    public TrendingMoviesIdsService(TrendingMoviesService trendingMoviesService) {
        this.trendingMoviesService = trendingMoviesService;
    }

    @Override
    public void getTrendingMoviesIds(request request, io.grpc.stub.StreamObserver<RatingList> responseObserver) {
        RatingList rl = trendingMoviesService.ping();

//        RatingList.Builder reply = RatingList.newBuilder()
//                .addRatingList(new Rating().newBuilderForType().setMovieId(Integer.parseInt("500")).setRating(4));
        responseObserver.onNext(rl);
        responseObserver.onCompleted();
    }
}
