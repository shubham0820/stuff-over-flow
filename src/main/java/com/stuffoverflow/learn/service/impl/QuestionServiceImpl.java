package com.stuffoverflow.learn.service.impl;

import com.stuffoverflow.learn.entity.Question;
import com.stuffoverflow.learn.entity.User;
import com.stuffoverflow.learn.payload.QuestionDto;
import com.stuffoverflow.learn.repository.QuestionRepo;
import com.stuffoverflow.learn.repository.UserRepo;
import com.stuffoverflow.learn.service.QuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private UserRepo userRepo;
    @Override
    public QuestionDto createQuestion(QuestionDto questionDto, int userId) {
        User ownedByUser = this.userRepo.findById(userId).orElseThrow(()->
                new RuntimeException("user not found with id " + userId));

        Question quesToCreate = this.modelMapper.map(questionDto, Question.class);

        quesToCreate.setUser(ownedByUser);
        quesToCreate.setCreatedTimestamp(new Date());

        Question createdQuestion = this.questionRepo.save(quesToCreate);
        return this.modelMapper.map(createdQuestion, QuestionDto.class);
    }

    @Override
    public QuestionDto getQuestion(Integer questionId) {
        Question question = this.questionRepo.findById(questionId).orElseThrow(() ->
                new RuntimeException("question with id " + questionId + "doesn't exists"));
        return this.modelMapper.map(question, QuestionDto.class);
    }

    @Override
    public List<QuestionDto> getQuestions() {
        return null;
    }


    /*
    Only title & description of a Question can be updated
    * */
    @Override
    public QuestionDto updateQuestion(int questionId, QuestionDto questionDto) {
        Question questionToUpdate = this.questionRepo.findById(questionId).orElseThrow(
                () -> new RuntimeException("question with id "+questionId+" not found"));

        questionToUpdate.setTitle(questionDto.getTitle());
        questionToUpdate.setDescription(questionDto.getDescription());

        Question updatedQuestion = this.questionRepo.save(questionToUpdate);

        return this.modelMapper.map(updatedQuestion, QuestionDto.class);
    }

    @Override
    public void deleteQuestion(Integer questionId) {
        Question questionToDelete = this.questionRepo.findById(questionId).orElseThrow(
                ()->new RuntimeException("question with id "+questionId+" not found"));

        this.questionRepo.delete(questionToDelete);
    }
}
