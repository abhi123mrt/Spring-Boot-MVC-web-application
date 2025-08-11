package com.abhinav.Quiz_Web_App.Service;

import com.abhinav.Quiz_Web_App.Repository.Login_Repo;
import com.abhinav.Quiz_Web_App.Repository.Register_Repo;
import com.abhinav.Quiz_Web_App.model.Login;
import com.abhinav.Quiz_Web_App.model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Login_Service {

@Autowired
Register_Repo registerRepo;
public boolean authenticateUser(String email, String password) {
    Register user = registerRepo.findByEmail(email);
    if (user == null) {
        System.out.println("Login failed: No user found for email " + email);
        return false;
    } else if (!user.getPassword().equals(password)) {
        System.out.println("Login failed: Incorrect password for email " + email);
        return false;
    } else {
        System.out.println("Login successful for: " + email);
        return true;
    }
}



public Register getUserByEmail(String email) {
    System.out.println("Fetching user details for: " + email);
    return registerRepo.findByEmail(email);
}


}

