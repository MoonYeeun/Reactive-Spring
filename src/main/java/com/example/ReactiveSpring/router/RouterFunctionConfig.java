package com.example.ReactiveSpring.router;

import com.example.ReactiveSpring.handler.SampleHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class RouterFunctionConfig {
    @Bean
    public RouterFunction<ServerResponse> route(SampleHandler sampleHandler) {
        return RouterFunctions
                .route(GET("/functional/flux")
                        .and(accept(MediaType.APPLICATION_JSON)), sampleHandler::flux)
                .andRoute(GET("/functional/mono").and(accept(MediaType.APPLICATION_JSON)), sampleHandler::mono);

    }
}
