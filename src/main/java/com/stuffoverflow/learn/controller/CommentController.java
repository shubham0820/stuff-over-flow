package com.stuffoverflow.learn.controller;

import com.stuffoverflow.learn.payload.CommentDto;
import com.stuffoverflow.learn.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;
    // create
    @PostMapping("/")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto){
        CommentDto createdComment = this.commentService.createComment(commentDto);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }
    // read

    // update

    // delete
}
