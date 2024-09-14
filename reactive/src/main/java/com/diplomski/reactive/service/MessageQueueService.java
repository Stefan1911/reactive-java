package com.diplomski.reactive.service;

import com.diplomski.reactive.model.StockQuote;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.rabbitmq.OutboundMessage;
import reactor.rabbitmq.QueueSpecification;
import reactor.rabbitmq.Sender;

@Log4j2
@Service
@RequiredArgsConstructor
public class MessageQueueService {

    private final Sender sender;

    private static final String QUEUE = "stock-quote-queue";

    @PreDestroy
    public void close() throws Exception {
        sender.close();
    }

    public Mono<Boolean> sendMessage(StockQuote stockQuote) {
        var message =  new OutboundMessage("", QUEUE, stockQuote.toString().getBytes());
        var outboundFlux = Flux.just(message);

        sender.declareQueue(QueueSpecification.queue(QUEUE))
                .thenMany(sender.sendWithPublishConfirms(outboundFlux))
                .doOnError(e -> log.error("Send failed", e))
                .subscribe(m -> {
                    if(m.isAck()) {
                        log.info("Message sent");
                    }
                });

        return Mono.just(true);
    }
}
