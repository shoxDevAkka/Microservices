package com.example.demo1;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

//@Service
public class Demo1ServiceImpl {

    private final RestTemplate restTemplate;

    public Demo1ServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String hello() {
        String responseFromDemo2 = restTemplate.getForObject("http://demo2", String.class);
        String result = "Hello microservices1" + responseFromDemo2;
        return result;
    }

    public MessageDTO message(Long id) {
        MessageFromDemo2DTO messageFromDemo2DTO = restTemplate.postForObject("http://demo2/message/" + id, null,
                MessageFromDemo2DTO.class);

        if (messageFromDemo2DTO == null){
            return null;
        }

//        return new MessageDTO(id, messageFromDemo2DTO.getBody(), new Date().getTime());       // that is correct return value, it is done because we learned new version of implementing that kind of code
        return null;        // that is not correct version of return value
    }
}
