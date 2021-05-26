package com.example.soon.handler;

import com.example.soon.model.dto.ProductReq;
import com.example.soon.model.vo.ProductVo;
import com.example.soon.service.SoonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class SoonHandler {
    private final SoonService service;

    public Mono<ServerResponse> createProduct(ServerRequest request) {
        return request.bodyToMono(ProductReq.class)
                .flatMap(body->{
                    ProductVo vo = ProductVo.builder()
                            .name(body.getName())
                            .price(body.getPrice())
                            .build();
                    return ServerResponse.ok().body(service.createProduct(vo),String.class);
                });
    }

}
