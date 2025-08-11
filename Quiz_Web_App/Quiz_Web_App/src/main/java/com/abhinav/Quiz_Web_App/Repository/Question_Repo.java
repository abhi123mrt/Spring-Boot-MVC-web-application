package com.abhinav.Quiz_Web_App.Repository;

import com.abhinav.Quiz_Web_App.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Question_Repo extends JpaRepository<Question,Integer> {
    List<Question> findByTitleIgnoreCaseAndDifficultyIgnoreCase(String title, String difficulty);

}
