package com.helloworld.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AccountController {

    @GetMapping("/")
    public ResponseEntity<String> createAccount() {
        return new ResponseEntity<>("Hello, world!",
                HttpStatus.OK);
    }

    @GetMapping("/heresy")
    public ResponseEntity<String> heresy() {
        return new ResponseEntity<>("Магнус не предавал!!!",
                HttpStatus.OK);
    }
}