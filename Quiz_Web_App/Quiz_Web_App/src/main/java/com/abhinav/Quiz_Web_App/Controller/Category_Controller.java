package com.abhinav.Quiz_Web_App.Controller;

import com.abhinav.Quiz_Web_App.Repository.Category_Repo;
import com.abhinav.Quiz_Web_App.Service.Category_service;
import com.abhinav.Quiz_Web_App.model.Category;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@Controller
@RequestMapping("category")
public class Category_Controller {
    @Autowired
    Category_service categoryService;
    @Autowired
    Category_Repo categoryRepo;
    @GetMapping("create")
    public String CreateCategory(@RequestParam String title,@RequestParam String descriptions,@RequestParam String subCategories){
        categoryService.createCategory(title,descriptions,subCategories);
       return "Added Succesfully ";
    }
    @GetMapping("all")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
    @GetMapping("/view")
    public String viewCategories(Model model) {

        model.addAttribute("categories", categoryRepo.findAll());
        return "Categories";
    }
    @GetMapping("/select")
    public String showCategoryPage(HttpSession session) {
        Boolean isSubmitted = (Boolean) session.getAttribute("quizSubmitted");

        if (isSubmitted == null || !isSubmitted) {
            return "redirect:/"; // Or redirect to a warning page
        }

        session.removeAttribute("quizSubmitted"); // Clear the flag after showing
        return "Categories";

    }



}
