package com.diplomski.non_reactive.service;

import com.diplomski.non_reactive.model.StockQuote;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CacheService {


    public Boolean cache(final StockQuote stockQuote) {
        return true;
    }
}
