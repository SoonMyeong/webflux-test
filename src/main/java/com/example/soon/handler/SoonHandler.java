package com.example.soon.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class SoonHandler {

    public Mono<ServerResponse> createProduct(ServerRequest request) {
        return ServerResponse.ok().bodyValue("mock");
    }

}
