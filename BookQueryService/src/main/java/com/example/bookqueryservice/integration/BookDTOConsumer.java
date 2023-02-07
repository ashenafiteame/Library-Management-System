package com.example.bookqueryservice.integration;


import com.example.bookqueryservice.service.BookDTO;
import com.example.bookqueryservice.service.BookService;
import com.example.bookqueryservice.service.ReviewDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class BookDTOConsumer {
    @Autowired
    BookService bookService;
    ObjectMapper om = new ObjectMapper();

    @KafkaListener(topics = AppConstants.TOPIC_NAME,
            groupId = AppConstants.GROUP_ID)
    public void ConsumeBookMessage(@Payload Object bookMessage,@Headers MessageHeaders headers){
        ConsumerRecord bookMessage1 = (ConsumerRecord) bookMessage;
        BookMessage bookMessage2 = om.convertValue(bookMessage1.value(), new TypeReference<BookMessage>() {
        });
        System.out.println("------message sent to kafka consumed-----------" + bookMessage2.getBookDTO());

        BookDTO bookDTO = bookMessage2.getBookDTO();
        String operation = bookMessage2.getOperationType();
        if (operation.equals("update")){
            bookService.updateBook(bookDTO);
        }
        if (operation.equals("save")){
            bookService.addBook(bookDTO);
        }

    }
    @KafkaListener(topics = "reviewoperation",
            groupId = AppConstants.GROUP_ID)
    public void ConsumeReviewMessage(@Payload Object reviewMessage,@Headers MessageHeaders headers){

    ConsumerRecord record=(ConsumerRecord) reviewMessage;
    ReviewMessage reviewMessage1=om.convertValue(record.value(), new TypeReference<ReviewMessage>() {
    });
        System.out.println("------message sent to kafka consumed-----------"+reviewMessage1.getReviewDTO());
        ReviewDTO reviewDTO=reviewMessage1.getReviewDTO();
        String operation = reviewMessage1.getOperationType();
        if (operation.equals("update")){
            bookService.updateReview(reviewDTO);
        }
        if (operation.equals("save")){
            bookService.updateReview(reviewDTO);
        }

    }
}
