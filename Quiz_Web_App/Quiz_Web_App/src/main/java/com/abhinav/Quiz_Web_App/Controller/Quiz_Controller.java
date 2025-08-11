package com.abhinav.Quiz_Web_App.Controller;

import com.abhinav.Quiz_Web_App.Repository.Question_Repo;
import com.abhinav.Quiz_Web_App.Service.Result_Service;
import com.abhinav.Quiz_Web_App.model.Question;
import com.abhinav.Quiz_Web_App.model.Result;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class Quiz_Controller {

    @Autowired
    Question_Repo questionRepo;

    @Autowired
    Result_Service resultService;

    @PostMapping("/submit-quiz")
    public String submitQuiz(@RequestParam Map<String, String> formData, Model model, HttpSession session) {
        String username = formData.get("username");
        String category = formData.get("category");

        int total = (int) session.getAttribute("total");
        int attempted = 0;
        int correct = 0;

        for (Map.Entry<String, String> entry : formData.entrySet()) {
            if (entry.getKey().startsWith("q")) {
                total++;
                int questionId = Integer.parseInt(entry.getKey().substring(1));
                String selected = entry.getValue();

                Question question = questionRepo.findById(questionId).orElse(null);
                if (question != null) {
                    attempted++;
                    if (selected.equalsIgnoreCase(question.getRight_answer())) {
                        correct++;
                    }
                }
            }
        }

        int wrong = attempted - correct;
        int score = correct * 1; // 1 mark per correct

        Result result = new Result();
        result.setUsername(username);
        result.setCategory(category);
        result.setTotal_question(total);
        result.setAttempted(attempted);
        result.setCorrect_answer(correct);
        result.setWrong_answer(wrong);
        result.setScore(score);

        resultService.GetResultByCategory(username, category, total, attempted, correct, wrong, score);
        session.setAttribute("quizSubmitted", true);
        model.addAttribute("result", result);
        return "result"; // ✅ This will open result.html
    }
}
