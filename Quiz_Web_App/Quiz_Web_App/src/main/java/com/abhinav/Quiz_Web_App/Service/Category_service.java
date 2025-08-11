package com.abhinav.Quiz_Web_App.Service;

import com.abhinav.Quiz_Web_App.Repository.Category_Repo;
import com.abhinav.Quiz_Web_App.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Category_service {
    @Autowired
    Category_Repo categoryRepo;
    public void createCategory(String title, String descriptions, String subCategories) {
        Category category=new Category();
        category.setTitle(title);
        category.setDiscriptions(descriptions);
        category.setSubCategories(subCategories);
        categoryRepo.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }
}
