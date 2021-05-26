package com.example.soon.service;

import com.example.soon.model.vo.ProductVo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SoonService {

    public Mono<String> createProduct(ProductVo vo) {
        return Mono.just("아직 미완성");
    }
}
