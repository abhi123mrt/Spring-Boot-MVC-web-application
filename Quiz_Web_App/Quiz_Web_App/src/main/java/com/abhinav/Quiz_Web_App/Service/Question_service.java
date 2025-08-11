package com.abhinav.Quiz_Web_App.Service;

import com.abhinav.Quiz_Web_App.Repository.Question_Repo;
import com.abhinav.Quiz_Web_App.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Question_service {
    @Autowired
    Question_Repo questionRepo;


    public void saveQuestion(Question questions) {
        questionRepo.save(questions);
    }

public List<Question> GetQuestionByCategory(String title, String difficulty) {
    return questionRepo.findByTitleIgnoreCaseAndDifficultyIgnoreCase(title.trim(), difficulty.trim());
}

    public List<Question> getAllQuestionByTitleAndDifficulty(String title, String difficulty) {
        return questionRepo.findByTitleIgnoreCaseAndDifficultyIgnoreCase(title.trim(), difficulty.trim());
    }

}
