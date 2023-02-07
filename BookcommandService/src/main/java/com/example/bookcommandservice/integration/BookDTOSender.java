package com.example.bookcommandservice.integration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.messaging.Message;

@Service
public class BookDTOSender {
    @Autowired
    KafkaTemplate<String,BookMessage> kafkaTemplate;

    public void sendBookMessage(BookMessage bookMessage){

        Message<BookMessage> message = MessageBuilder
                .withPayload(bookMessage)
                .setHeader(KafkaHeaders.TOPIC,AppConstants.TOPIC_NAME)
                        .build();
        this.kafkaTemplate.send(message);
       // kafkaTemplate.send(AppConstants.TOPIC_NAME,bookMessage);
        System.out.println("------message sent to kafka about book operation update-----------");
    }
}
