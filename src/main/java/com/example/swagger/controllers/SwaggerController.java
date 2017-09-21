package com.example.swagger.controllers;

import com.example.swagger.controllers.model.MessageDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Mark Cunningham on 9/21/2017.
 */
@RestController
@RequestMapping("/")
public class SwaggerController {

    @GetMapping(value = "/{message}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageDto> pathHello(@PathVariable("message") String message) {
        MessageDto helloMessage = new MessageDto();
        helloMessage.setMessage(message);
        return ResponseEntity.ok(helloMessage);
    }

}
