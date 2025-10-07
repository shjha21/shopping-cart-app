package com.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.User;
import com.repository.UserRepo;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@Component
@WebListener
public class MySessionListener implements HttpSessionListener {

    @Autowired
    private UserRepo userRepository; // or your user service

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session=se.getSession();
        session.setMaxInactiveInterval(10);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Get user info from session
        HttpSession session = se.getSession();
        String username = (String) session.getAttribute("username");

        if (username != null) {
            // Update DB flag
            User user = userRepository.findByUsername(username);
            if (user != null) {
                user.setFlag(0);
                userRepository.save(user);
                System.out.println("User " + username + " logged out due to session timeout");
            }
        }
    }
}
