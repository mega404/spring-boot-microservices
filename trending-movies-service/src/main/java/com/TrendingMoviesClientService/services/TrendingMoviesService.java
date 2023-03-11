package com.TrendingMoviesClientService.services;

import com.TrendingMoviesClientService.RatingList;
import com.TrendingMoviesClientService.TrendingMoviesIdsServiceGrpc;
import com.TrendingMoviesClientService.request;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import net.devh.boot.grpc.server.service.GrpcService;
//import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import static com.TrendingMoviesClientService.TrendingMoviesIdsServiceGrpc.newBlockingStub;

@Service
public class TrendingMoviesService {

//    private TrendingMoviesIdsServiceGrpc.TrendingMoviesIdsServiceBlockingStub myServiceStub;
//
//    public RatingList getTrending(String req) {
//        request r = request.newBuilder().setReqMessage("hello")
//                .build();
//        return myServiceStub.getTrendingMoviesIds(r).next();
//    }

    public RatingList ping() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091)
                .usePlaintext()
                .build();
        TrendingMoviesIdsServiceGrpc.TrendingMoviesIdsServiceBlockingStub stub
                = newBlockingStub(channel);
        request r = request.newBuilder().setReqMessage("hello")
                .build();
//        channel.shutdown();
        return stub.getTrendingMoviesIds(r).next();
    }

}