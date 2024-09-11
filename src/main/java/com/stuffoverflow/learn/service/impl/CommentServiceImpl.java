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
        User postedByUser = this.userRepo.findById(commentDto.getPostedByUserId()).orElseThrow(() -> new RuntimeException());
        Answer commentedOnAnswer = this.answerRepo.findById(commentDto.getCommentedOnAnswerId()).orElseThrow(() -> new RuntimeException());

        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        comment.setPostedByUser(postedByUser);
        comment.setCommentedOnAnswer(commentedOnAnswer);
        comment.setCreationTime(new Date());

        Comment createdComment = this.commentRepo.save(comment);

        return this.modelMapper.map(createdComment, CommentDto.class);
    }

    @Override
    public CommentDto getComment(int commentId) {
        return null;
    }

    @Override
    public CommentDto updateComment(CommentDto commentDto) {
        return null;
    }

    @Override
    public void deleteComment(int commentId) {

    }
}
