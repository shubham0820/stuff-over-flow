package com.stuffoverflow.learn.controller;

import com.stuffoverflow.learn.payload.CommentDto;
import com.stuffoverflow.learn.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/commentId={commentId}")
    public ResponseEntity<CommentDto> fetchComment(@PathVariable("commentId") int commentId){
        CommentDto commentDto = this.commentService.getComment(commentId);
        return new ResponseEntity<>(commentDto, HttpStatus.FOUND);
    }

    // update
    @PutMapping("/")
    public ResponseEntity<CommentDto> updateComment(@RequestBody CommentDto commentDto){
        CommentDto updatedComment = this.commentService.updateComment(commentDto);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    // delete
    @DeleteMapping("/commentId={commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable("commentId") int commentId){
        this.commentService.deleteComment(commentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
