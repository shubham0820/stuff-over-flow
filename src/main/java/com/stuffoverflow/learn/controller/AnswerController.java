package com.stuffoverflow.learn.controller;

import com.stuffoverflow.learn.payload.AnswerDto;
import com.stuffoverflow.learn.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;
    //create
    @PostMapping("/")
    public ResponseEntity<AnswerDto> createAnswer(@RequestBody AnswerDto answerDto){
        AnswerDto createdAns;
        try{
            createdAns = answerService.createAnswer(answerDto);
        }catch (Exception ex){
            System.out.println("could not create a new answer due to " + ex.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdAns, HttpStatus.CREATED);
    }

    //read
    @GetMapping("/")
    public ResponseEntity<List<AnswerDto>> getAnswers(){
        List<AnswerDto> listOfAnswers = this.answerService.getAnswers();
        return new ResponseEntity<>(listOfAnswers, HttpStatus.FOUND);
    }

    //update
    @PutMapping("/")
    public ResponseEntity<AnswerDto> updateAnswer(@RequestBody() AnswerDto answerDto){
        AnswerDto currAns = this.answerService.updateAnswer(answerDto);
        return new ResponseEntity<>(currAns, HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/answerId={answerId}")
    public ResponseEntity<Void> deleteAnswer(@RequestParam("answerId") int answerId){
        this.answerService.deleteAnswer(answerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
