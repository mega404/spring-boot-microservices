package com.example.ratingsservice.services;

import com.TrendingMoviesClientService.Rating;
import com.TrendingMoviesClientService.RatingList;
import com.TrendingMoviesClientService.TrendingMoviesIdsServiceGrpc;
import com.TrendingMoviesClientService.request;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.stereotype.Service;

@GrpcService
public class TrendingMoviesIdsService extends TrendingMoviesIdsServiceGrpc.TrendingMoviesIdsServiceImplBase {

    @Override
    public void getTrendingMoviesIds(request request, io.grpc.stub.StreamObserver<RatingList> responseObserver) {
//        System.out.println("dkslfjnjvnxckjvkjsfsdf");
        RatingList.Builder reply = RatingList.newBuilder()
                .addRatingList(new Rating().newBuilderForType().setMovieId(Integer.parseInt("500")).setRating(4));
        responseObserver.onNext(reply.build());
        responseObserver.onCompleted();
    }
}
