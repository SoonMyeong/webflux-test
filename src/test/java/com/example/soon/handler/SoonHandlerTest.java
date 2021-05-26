package com.example.soon.handler;

import com.example.soon.model.vo.ProductVo;
import com.example.soon.router.Router;
import com.example.soon.service.SoonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@DisplayName("router,handler 슬라이스 테스트")
@ContextConfiguration(classes = {Router.class,SoonHandler.class})
@WebFluxTest
class SoonHandlerTest {
    @Autowired
    private ApplicationContext context;
    @MockBean
    private SoonService service;


    private WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
        webTestClient = WebTestClient.bindToApplicationContext(context).build();
    }

    @Test
    @DisplayName("상품 등록 handler 테스트")
    void createProductTest() {
        ProductVo vo = ProductVo.builder()
                .name("쿠앤크")
                .price(1000)
                .build();
        String req = "{\"name\":\"쿠앤크\",\"price\":1000}";

        when(service.createProduct(vo)).thenReturn(Mono.just("성공"));
        this.webTestClient.post().uri("/create")
                .header("Content-Type","application/json")
                .bodyValue(req)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .value(result -> {
                    assertEquals(result, "성공");
                });

    }

}