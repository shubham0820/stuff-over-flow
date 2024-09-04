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
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


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

        User currUser = this.userRepo.findById(answerDto.getUserId()).orElseThrow(
                () -> new RuntimeException("user with id " + answerDto.getUserId() + "not found"));

        // if there's an answer which has been already created by the currUser, then dont let currUser create another ans
        if(this.answerRepository.findByUser(currUser) != null){
            throw new RuntimeException("an answer already exists from the user with id: " + answerDto.getUserId());
        }

        Question currQues = this.questionRepo.findById(answerDto.getQuestionId()).orElseThrow(
                () -> new RuntimeException("question with id " + answerDto.getQuestionId() + "not found"));

        Answer currAnswer = this.modelMapper.map(answerDto, Answer.class);
        currAnswer.setUser(currUser);
        currAnswer.setQuestion(currQues);

        Answer createdAnswer = this.answerRepository.save(currAnswer);

        return this.modelMapper.map(createdAnswer, AnswerDto.class);
    }

    @Override
    public List<AnswerDto> getAnswers() {
        List<Answer> listOfAnswers = this.answerRepository.findAll();
        List<AnswerDto> answerDtoList = listOfAnswers.stream().map(answer -> this.modelMapper.map(answer, AnswerDto.class)).collect(Collectors.toList());
        return answerDtoList;
    }

    @Override
    public AnswerDto updateAnswer(AnswerDto answerDto) {
        Answer currAns = this.answerRepository.findById(answerDto.getAnswerId()).orElseThrow(
                () -> new RuntimeException("answer with id " + answerDto.getUserId() + " not found"));

        currAns.setContent(answerDto.getContent());

        Answer savedAns = this.answerRepository.save(currAns);
        return this.modelMapper.map(savedAns, AnswerDto.class);
    }

    @Override
    public void deleteAnswer(int answerId) {
        this.answerRepository.deleteById(answerId);
    }
}
