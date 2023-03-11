package com.TrendingMoviesClientService;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8088)
                .usePlaintext()
                .build();

        TrendingMoviesIdsServiceGrpc.TrendingMoviesIdsServiceBlockingStub stub
                = TrendingMoviesIdsServiceGrpc.newBlockingStub(channel);

        RatingList helloResponse = stub.getTrendingMoviesIds(request.newBuilder().setReqMessage("hello")
                .build()).next();

        System.out.println(helloResponse.toString());

        channel.shutdown();
    }
}