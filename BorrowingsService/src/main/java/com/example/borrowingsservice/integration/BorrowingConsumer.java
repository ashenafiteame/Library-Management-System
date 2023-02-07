package com.example.borrowingsservice.integration;


import com.example.borrowingsservice.service.BorrowingsService;
import com.example.borrowingsservice.service.dto.BookDTO;
import com.example.borrowingsservice.service.dto.CustomerDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class BorrowingConsumer {
    @Autowired
    private BorrowingsService borrowingsService;


    ObjectMapper om = new ObjectMapper();

    @KafkaListener(topics = AppConstants.TOPIC_NAME,
            groupId = AppConstants.GROUP_ID)
    public void ConsumeBookMessage(@Payload Object bookMessage, @Headers MessageHeaders headers) {
        ConsumerRecord bookMessage1 = (ConsumerRecord) bookMessage;
        BookMessage bookMessage2 = om.convertValue(bookMessage1.value(), new TypeReference<BookMessage>() {
        });
        System.out.println(bookMessage2.getOperationType()+ " ------message sent to kafka consumed-----------" + bookMessage2.getBookDTO());

        BookDTO bookDTO = bookMessage2.getBookDTO();

        String operation = bookMessage2.getOperationType();
        if (operation.equals("update")){
            borrowingsService.updateBorrowingsBook(bookDTO);
        }
        if (operation.equals("save")){
            borrowingsService.updateBorrowingsfromBook(bookDTO);
        }

    }


    @KafkaListener(topics = "customeroperation",
            groupId = "group_id")
    public void ConsumeCustomerMessage(@Payload Object customerMessage, @Headers MessageHeaders headers) {
        ConsumerRecord customerMessage1 = (ConsumerRecord) customerMessage;

        CustomerMessage customerMessage2 = om.convertValue(customerMessage1.value(), new TypeReference<CustomerMessage>() {
        });
        System.out.println("------customer message sent to kafka consumed by borrowing-----------" + customerMessage2.getCustomerDTO());

        CustomerDTO customerDTO = customerMessage2.getCustomerDTO();
        String operation = customerMessage2.getOperationType();
        if (operation.equals("update")){
            borrowingsService.updateBorrowingsCustomer(customerDTO);
        }


    }
}
