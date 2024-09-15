package com.stuffoverflow.learn.service;

import com.stuffoverflow.learn.payload.AnswerDto;

import java.util.List;

public interface AnswerService {
    AnswerDto createAnswer(AnswerDto answerDto);
    AnswerDto getAnswers(int answerId);
    List<AnswerDto> getAnswers();
    AnswerDto updateAnswer(AnswerDto answerDto);
    void deleteAnswer(int answerId);
}
