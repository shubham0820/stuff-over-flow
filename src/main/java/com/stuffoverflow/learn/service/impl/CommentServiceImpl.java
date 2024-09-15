package com.stuffoverflow.learn.service.impl;

import com.stuffoverflow.learn.entity.Answer;
import com.stuffoverflow.learn.entity.Comment;
import com.stuffoverflow.learn.entity.User;
import com.stuffoverflow.learn.payload.CommentDto;
import com.stuffoverflow.learn.repository.AnswerRepository;
import com.stuffoverflow.learn.repository.CommentRepo;
import com.stuffoverflow.learn.repository.UserRepo;
import com.stuffoverflow.learn.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private AnswerRepository answerRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CommentDto createComment(CommentDto commentDto) {
        User postedByUser = this.userRepo.findById(commentDto.getPostedByUserId())
                .orElseThrow(() -> new RuntimeException("user with id "+commentDto.getPostedByUserId()+" not found"));
        Answer commentedOnAnswer = this.answerRepo.findById(commentDto.getAnswerId())
                .orElseThrow(() -> new RuntimeException("answer with id "+commentDto.getAnswerId()+" not found"));

        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        comment.setPostedByUser(postedByUser);
        comment.setAnswer(commentedOnAnswer);
        comment.setCreationTime(new Date());

        Comment createdComment = this.commentRepo.save(comment);

        return this.modelMapper.map(createdComment, CommentDto.class);
    }

    @Override
    public CommentDto getComment(int commentId) {
        Comment comment = this.commentRepo.findById(commentId)
                .orElseThrow(() -> new RuntimeException("comment with id "+commentId+" not found"));
        return this.modelMapper.map(comment, CommentDto.class);
    }

    @Override
    public CommentDto updateComment(CommentDto commentDto) {
        Comment comment = this.commentRepo.findById(commentDto.getCommentId())
                .orElseThrow(() -> new RuntimeException("comment with id "+commentDto.getCommentId()+" not found"));
        comment.setCommentContent(commentDto.getCommentContent());

        Comment updatedComment = this.commentRepo.save(comment);
        return this.modelMapper.map(updatedComment, CommentDto.class);
    }

    @Override
    public void deleteComment(int commentId) {
        this.commentRepo.deleteById(commentId);
    }
}
