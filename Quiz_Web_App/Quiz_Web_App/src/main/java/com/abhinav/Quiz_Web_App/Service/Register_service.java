package com.abhinav.Quiz_Web_App.Service;

import com.abhinav.Quiz_Web_App.Repository.Register_Repo;
import com.abhinav.Quiz_Web_App.model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Register_service {
    @Autowired
    Register_Repo registerRepo;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public Boolean createDetails(String name, String email, String phoneno, String password) {
        if (registerRepo.existsByEmail(email)) {
            return false;
        }
        Register register=new Register();
        register.setEmail(email);
        register.setName(name);
        register.setPhoneno(phoneno);
        register.setPassword(passwordEncoder.encode(password)); // hashed
       registerRepo.save(register);
       return true;
    }
    //new added for login
    public boolean authenticateUser(String email, String rawPassword) {
        Register user = registerRepo.findByEmail(email);
        if (user == null) return false;
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }

    public Register getUserByEmail(String email) {
        return registerRepo.findByEmail(email);
    }
}
