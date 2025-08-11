package com.abhinav.Quiz_Web_App.Repository;

import com.abhinav.Quiz_Web_App.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Result_Repo extends JpaRepository<Result,Integer> {
}
