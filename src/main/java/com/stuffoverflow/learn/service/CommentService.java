package com.stuffoverflow.learn.service;

import com.stuffoverflow.learn.payload.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto);
    CommentDto getComment(int commentId);
    CommentDto updateComment(CommentDto commentDto);
    void deleteComment(int commentId);
}
