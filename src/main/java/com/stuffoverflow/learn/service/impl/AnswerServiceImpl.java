package com.stuffoverflow.learn.service.impl;

import com.stuffoverflow.learn.entity.Answer;
import com.stuffoverflow.learn.entity.Question;
import com.stuffoverflow.learn.entity.User;
import com.stuffoverflow.learn.payload.AnswerDto;
import com.stuffoverflow.learn.payload.UserDto;
import com.stuffoverflow.learn.repository.AnswerRepository;
import com.stuffoverflow.learn.repository.QuestionRepo;
import com.stuffoverflow.learn.repository.UserRepo;
import com.stuffoverflow.learn.service.AnswerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private QuestionRepo questionRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AnswerDto createAnswer(AnswerDto answerDto) {
        Date createdTimestamp = new Date();
        answerDto.setCreatedTimestamp(createdTimestamp);

        User currUser = this.userRepo.getReferenceById(answerDto.getUserId());
        Question currQues = this.questionRepo.getReferenceById(answerDto.getQuestionId());

        Answer currAnswer = this.modelMapper.map(answerDto, Answer.class);
        currAnswer.setUser(currUser);
        currAnswer.setQuestion(currQues);

        Answer createdAnswer = this.answerRepository.save(currAnswer);

        return this.modelMapper.map(createdAnswer, AnswerDto.class);
    }
}
