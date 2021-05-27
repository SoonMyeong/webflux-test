package com.example.soon.service;

import com.example.soon.model.entity.Product;
import com.example.soon.model.vo.ProductVo;
import com.example.soon.repository.SoonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SoonService {
    private final SoonRepository soonRepository;

    public Mono<ProductVo> createProduct(ProductVo vo) {
        return Mono.just(soonRepository.save(Product.builder()
                .name(vo.getName())
                .price(vo.getPrice())
                .build())).flatMap(res->
                    Mono.just(ProductVo.builder()
                            .name(res.getName())
                            .price(res.getPrice())
                            .build()));
    }
}
