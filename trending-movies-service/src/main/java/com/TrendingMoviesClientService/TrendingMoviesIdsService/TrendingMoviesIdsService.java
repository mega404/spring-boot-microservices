package com.TrendingMoviesClientService.TrendingMoviesIdsService;

import com.TrendingMoviesClientService.Rating;
import com.TrendingMoviesClientService.RatingList;
import com.TrendingMoviesClientService.TrendingMoviesIdsServiceGrpc;
import com.TrendingMoviesClientService.request;
import net.devh.boot.grpc.server.service.GrpcService;

//@Service
@GrpcService
public class TrendingMoviesIdsService extends TrendingMoviesIdsServiceGrpc.TrendingMoviesIdsServiceImplBase {

    @Override
    public void getTrendingMoviesIds(request request, io.grpc.stub.StreamObserver<RatingList> responseObserver) {
//        String greeting = new StringBuilder()
//                .append("Hello, ")
//                .toString();
//
//        System.out.println("dkdksflksjdfa");
//
//        RatingList rl = new RatingList();
//        rl.newBuilderForType().addRatingList(new Rating().newBuilderForType().setMovieId(Integer.parseInt("500")).setRating(4));
//        responseObserver.onNext(rl);
//        responseObserver.onCompleted();
        RatingList.Builder reply = RatingList.newBuilder()
                .addRatingList(new Rating().newBuilderForType().setMovieId(Integer.parseInt("500")).setRating(4));
        responseObserver.onNext(reply.build());
        responseObserver.onCompleted();
    }
}
