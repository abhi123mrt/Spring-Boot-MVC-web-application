package com.abhinav.Quiz_Web_App.Repository;

import com.abhinav.Quiz_Web_App.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Category_Repo extends JpaRepository<Category,Integer> {
}
