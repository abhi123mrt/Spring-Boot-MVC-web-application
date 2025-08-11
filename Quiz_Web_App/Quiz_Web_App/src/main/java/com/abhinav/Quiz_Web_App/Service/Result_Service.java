package com.abhinav.Quiz_Web_App.Service;

import com.abhinav.Quiz_Web_App.Repository.Result_Repo;
import com.abhinav.Quiz_Web_App.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Result_Service {
    @Autowired
    Result_Repo resultRepo;
    public void GetResultByCategory(String username, String category, int totalQuestion, int attempted, int correctAnswer, int wrongAnswer, int score) {
        Result result = new Result();
        result.setUsername(username);
        result.setCategory(category);
        result.setTotal_question(totalQuestion);
        result.setAttempted(attempted);
        result.setCorrect_answer(correctAnswer);
        result.setWrong_answer(wrongAnswer);
        result.setScore(score);

        resultRepo.save(result);
    }
}
