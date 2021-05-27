package com.example.soon.service;

import com.example.soon.model.entity.Product;
import com.example.soon.model.vo.ProductVo;
import com.example.soon.repository.SoonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@DisplayName("Service 슬라이스 테스트")
class SoonServiceTest {
    @MockBean
    private SoonRepository soonRepository;

    private SoonService service;

    @BeforeEach
    void setUp() {
        this.service = new SoonService(soonRepository);
    }

    @Test
    @DisplayName("createProduct 테스트")
    void createProduct() {
        ProductVo vo = ProductVo.builder()
                .name("쿠앤크")
                .price(1000)
                .build();
        Product entity = Product.builder()
                .name("쿠앤크")
                .price(1000)
                .build();
        when(soonRepository.save(entity)).thenReturn(entity);

        Mono<ProductVo> req = service.createProduct(vo);

        StepVerifier.create(req)
                .thenConsumeWhile(result-> {
                    assertEquals(result.getName(),"쿠앤크");
                    assertEquals(result.getPrice(),1000);
                    return true;
                })
                .verifyComplete();

    }


}