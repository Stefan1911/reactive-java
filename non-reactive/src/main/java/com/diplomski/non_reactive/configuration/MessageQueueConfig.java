package com.diplomski.non_reactive.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageQueueConfig {

//    @Bean
//    Mono<Connection> connectionMono() {
//        ConnectionFactory connectionFactory = new ConnectionFactory();
//        connectionFactory.useNio();
//        return Mono.fromCallable(() -> connectionFactory.newConnection("reactor-rabbit")).cache();
//    }
//
//    @Bean
//    public SenderOptions senderOptions(Mono<Connection> connectionMono) {
//        return new SenderOptions()
//                .connectionMono(connectionMono)
//                .resourceManagementScheduler(Schedulers.boundedElastic());
//    }
//
//    @Bean
//    public Sender sender(SenderOptions senderOptions) {
//        return RabbitFlux.createSender(senderOptions);
//    }
}
