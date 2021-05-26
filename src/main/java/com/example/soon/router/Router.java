package com.example.soon.router;

import com.example.soon.handler.SoonHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class Router {
    @Bean
    RouterFunction<ServerResponse> routes(SoonHandler handler) {
        return RouterFunctions.route()
                .POST("/create",handler::createProduct)
                .build();
    }
}
