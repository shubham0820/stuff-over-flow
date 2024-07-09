package com.stuffoverflow.learn.service;


import com.stuffoverflow.learn.payload.QuestionDto;
import com.stuffoverflow.learn.payload.UserDto;

import java.util.List;

public interface QuestionService {
    QuestionDto createQuestion(QuestionDto questionDto, int userId);
    QuestionDto getQuestion(Integer questionId);
    List<QuestionDto> getQuestions();
    QuestionDto updateQuestion(QuestionDto questionDto);
    QuestionDto deleteQuestion(Integer questionId);

}
