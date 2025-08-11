package com.abhinav.Quiz_Web_App.Service;

import com.abhinav.Quiz_Web_App.Repository.Register_Repo;
import com.abhinav.Quiz_Web_App.model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private Register_Repo registerRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Register user = registerRepo.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),                    // username or login key
                user.getPassword(),                // already encrypted password
                Collections.emptyList()            // authorities (roles), empty for now
        );
    }
}
