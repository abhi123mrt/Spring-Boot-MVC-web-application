package com.abhinav.Quiz_Web_App.Controller;

import com.abhinav.Quiz_Web_App.Service.Result_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("result")
public class Result_Controller {
    @Autowired
    Result_Service resultService;
    //show result
    @GetMapping("score")
    public String ShowResult(@RequestParam String username,@RequestParam String category,@RequestParam String email,@RequestParam int total_question,@RequestParam int attempted,@RequestParam int correct_answer,@RequestParam int wrong_answer,@RequestParam int score){
        resultService.GetResultByCategory(username,category,total_question,attempted,correct_answer,wrong_answer,score);
        return "Final Result of the quiz";
    }
}
