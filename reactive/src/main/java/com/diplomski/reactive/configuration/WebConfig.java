package com.diplomski.reactive.configuration;

import com.diplomski.reactive.controller.GreetingHandler;
import com.diplomski.reactive.controller.StockQuoteController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration(proxyBeanMethods = false)
public class WebConfig {

    @Bean
    public RouterFunction<ServerResponse> route(
            final GreetingHandler greetingHandler,
            final StockQuoteController stockQuoteController) {

        return RouterFunctions
                .route(GET("/hello").and(accept(MediaType.APPLICATION_JSON)), greetingHandler::hello);
    }

    @Bean
    public WebClient webClient(){
        return WebClient.builder().build();
    }
}