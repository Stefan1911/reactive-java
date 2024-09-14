package com.diplomski.non_reactive.service;

import com.diplomski.non_reactive.model.StockQuote;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class MessageQueueService {

    private final RabbitTemplate rabbitTemplate;

    private static final String QUEUE = "stock-quote-queue-test";

    public Boolean sendMessage(StockQuote stockQuote) {
        rabbitTemplate.convertAndSend(QUEUE, stockQuote.toString());

       return true;
    }
}
