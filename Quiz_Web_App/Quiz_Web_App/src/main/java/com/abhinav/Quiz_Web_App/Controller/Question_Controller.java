package com.abhinav.Quiz_Web_App.Controller;

import com.abhinav.Quiz_Web_App.Service.Question_service;
import com.abhinav.Quiz_Web_App.model.Question;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("question")
public class Question_Controller {
    @Autowired
    Question_service questionService;

    //add a questions
    @PostMapping("add")
    public ResponseEntity<String> AddQuestion(@RequestBody List<Question> questions) {
        for (Question q : questions) {
            questionService.saveQuestion(q);
        }
        return new ResponseEntity<>("Question added successfully", HttpStatus.OK);
    }

    //get the questions
    @GetMapping("get")
    @ResponseBody
    public List<Question> GetQuestion(@RequestParam String title, @RequestParam String difficulty) {
        return questionService.GetQuestionByCategory(title, difficulty);
    }
    // print question on html page
    @GetMapping("View")
    public String ShowQuestion(@RequestParam String title, @RequestParam String difficulty, Model model, HttpSession session){
       List<Question> questions=questionService.getAllQuestionByTitleAndDifficulty(title,difficulty);
        if (questions.isEmpty()) {
            model.addAttribute("errorMessage", "No questions found for the given title and difficulty.");
            return "quiz";  // The quiz.html will show error message
        }
        // ✅ Shuffle and pick first 30 questions
        Collections.shuffle(questions);
        List<Question> selectedQuestions = questions.stream().limit(30).toList();
        // for time limit
        int timeLimit = 0;
        switch (difficulty.toLowerCase()) {
            case "easy": timeLimit = 10; break;
            case "medium": timeLimit = 20; break;
            case "hard": timeLimit = 30; break;
        }

        session.setAttribute("total", selectedQuestions.size()); // ✅ Use selected list size
        model.addAttribute("questions", selectedQuestions);
        model.addAttribute("timeLimit", timeLimit); // ✅ Important!
        return "quiz";
    }
}


