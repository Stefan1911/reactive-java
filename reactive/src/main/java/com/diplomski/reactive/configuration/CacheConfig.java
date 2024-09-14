package com.diplomski.reactive.configuration;

import com.diplomski.reactive.model.StockQuote;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class CacheConfig {

    @Bean
    ReactiveRedisOperations<String, StockQuote> redisOperations(ReactiveRedisConnectionFactory factory) {
        Jackson2JsonRedisSerializer<StockQuote> serializer = new Jackson2JsonRedisSerializer<>(StockQuote.class);

        RedisSerializationContext.RedisSerializationContextBuilder<String, StockQuote> builder =
                RedisSerializationContext.newSerializationContext(new StringRedisSerializer());

        RedisSerializationContext<String, StockQuote> context = builder.value(serializer).build();

        return new ReactiveRedisTemplate<>(factory, context);
    }
}
