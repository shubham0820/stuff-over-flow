package com.stuffoverflow.learn.controller;

import com.stuffoverflow.learn.payload.QuestionDto;
import com.stuffoverflow.learn.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    // create
    @PostMapping("/userId={userId}")
    private ResponseEntity<QuestionDto> createQuestion(@RequestBody QuestionDto questionDto,
                                                       @PathVariable("userId") int userId){
        QuestionDto createdQuestion = this.questionService.createQuestion(questionDto, userId);
        return new ResponseEntity<>(createdQuestion, HttpStatus.CREATED);
    }

    // read
    @GetMapping("/id={questionId}")
    private ResponseEntity<QuestionDto> getQuestion(@PathVariable("questionId") int questionId){
        QuestionDto questionDto = this.questionService.getQuestion(questionId);
        return new ResponseEntity<>(questionDto, HttpStatus.FOUND);
    }


    // update

    // delete
}
