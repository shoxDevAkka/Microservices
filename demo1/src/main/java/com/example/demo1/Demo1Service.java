package com.example.demo1;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "demo2")
public interface Demo1Service {

    @GetMapping
    String hello();

    @PostMapping("/message/{id}")       // it will only post the endpoint request which is not act as normal "RestController"
    MessageDTO message(@PathVariable Long id);      // in this case it does not mean that it is rest controller, and it functions like that but it is opposite of that it means it will receive param and through "@PathVariable" annotation it will place it to the endpoint where {id} is located it is completely opposite request

}
