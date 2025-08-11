package com.abhinav.Quiz_Web_App.Controller;

import com.abhinav.Quiz_Web_App.Service.Login_Service;
import com.abhinav.Quiz_Web_App.model.Register;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Login_Controller {
    @Autowired
    Login_Service loginService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  // Renders login.html from templates
    }

    @PostMapping("/submit-form")
    public String createUserDetail(
                                   @RequestParam String email,
                                   @RequestParam String password, HttpSession session, Model model) {


        boolean isValid = loginService.authenticateUser(email, password);

        if (isValid) {
            Register user = loginService.getUserByEmail(email);
            session.setAttribute("username", user.getName()); // or set userId as well
            return "redirect:/category/view";
        } else {
            model.addAttribute("error", "Invalid credentials. Try again.");
            return "login"; // back to login page
        }


    }
}

