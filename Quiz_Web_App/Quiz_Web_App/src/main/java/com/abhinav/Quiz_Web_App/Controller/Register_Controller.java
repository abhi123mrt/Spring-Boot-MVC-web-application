package com.abhinav.Quiz_Web_App.Controller;

import com.abhinav.Quiz_Web_App.Service.Register_service;
import com.abhinav.Quiz_Web_App.model.Register;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Register_Controller {
    @Autowired
    Register_service registerService;
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("register", new Register()); // matches th:object="${register}"
        return "register"; // refers to register.html
    }
    @PostMapping("/register/save")
    public String createUserDetail(@RequestParam String name,
                                   @RequestParam String email,
                                   @RequestParam String phoneno,
                                   @RequestParam String password,
                                   HttpSession session
                                   ,Model model) {
        boolean success = registerService.createDetails(name, email, phoneno, password);


        if (!success) {
            model.addAttribute("register", new Register());
            model.addAttribute("error", "Email or username already registered! Please Login With your Account");
            return "register";
        }


        session.setAttribute("username", name);
        return "redirect:/category/view";
    }
}
