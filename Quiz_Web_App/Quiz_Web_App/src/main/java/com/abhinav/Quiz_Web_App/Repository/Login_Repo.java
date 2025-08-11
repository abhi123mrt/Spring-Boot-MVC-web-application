package com.abhinav.Quiz_Web_App.Repository;

import com.abhinav.Quiz_Web_App.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Login_Repo extends JpaRepository<Login,Integer> {

}
