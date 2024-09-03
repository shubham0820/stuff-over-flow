package com.stuffoverflow.learn.controller;

import com.stuffoverflow.learn.payload.AnswerDto;
import com.stuffoverflow.learn.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;
    //create
    @PostMapping("/")
    public ResponseEntity<AnswerDto> createAnswer(@RequestBody AnswerDto answerDto){
        AnswerDto createdAns = answerService.createAnswer(answerDto);
        return new ResponseEntity<>(createdAns, HttpStatus.CREATED);
    }

    //read

    //update

    //delete
}
