package com.example.reviewservice.integration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class ReviewDTOSender {
    @Autowired
    KafkaTemplate<String, ReviewMessage> kafkaTemplate;

    public void sendCustomerMessage(ReviewMessage customerMessage){

        Message<ReviewMessage> message = MessageBuilder
                .withPayload(customerMessage)
                .setHeader(KafkaHeaders.TOPIC,AppConstants.TOPIC_NAME)
                        .build();
        this.kafkaTemplate.send(message);

        System.out.println("------message sent to kafka about review operation update----------- topic= "+AppConstants.TOPIC_NAME);
    }
}
