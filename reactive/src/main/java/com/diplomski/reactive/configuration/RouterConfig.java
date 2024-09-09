package com.diplomski.reactive.configuration;

import com.diplomski.reactive.hendler.GreetingHandler;
import com.diplomski.reactive.hendler.StockQuoteHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration(proxyBeanMethods = false)
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> route(
            final GreetingHandler greetingHandler,
            final StockQuoteHandler stockQuoteHandler) {

        return RouterFunctions
                .route(GET("/hello").and(accept(MediaType.APPLICATION_JSON)), greetingHandler::hello);
                //.route(POST("/quote").and(accept(MediaType.APPLICATION_JSON)), stockQuoteHandler::create);

    }
}