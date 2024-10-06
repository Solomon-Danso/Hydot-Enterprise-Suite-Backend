package com.hydottech.HES_Backend.Controller;

import com.hydottech.HES_Backend.Entity.Users;
import com.hydottech.HES_Backend.Global.GlobalConstants;
import com.hydottech.HES_Backend.Global.GlobalFunctions;
import com.hydottech.HES_Backend.Service.EmailService;
import com.hydottech.HES_Backend.Service.UserServiceInterface;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UsersController {
    @Autowired
    private UserServiceInterface userServiceInterface;

    @Autowired
    private EmailService emailService; // Inject EmailService here

    @Autowired
    private BCryptPasswordEncoder passwordEncoder; // Inject BCryptPasswordEncoder



    @GetMapping("/")
    public String Test(){
    return "Let Start The Hydot Commerce System";
}


    @PostMapping("/Register")
    public ResponseEntity<Map<String, Object>> registerUser(@ModelAttribute Users users,
                                                            @RequestParam(value = "userPic", required = false) MultipartFile picture) {
        Map<String, Object> response = new HashMap<>();

        if (picture != null && !picture.isEmpty()) {
            String fileName = GlobalFunctions.saveFile(picture);
            users.setPicture(fileName);
        }

        String generatedUserId;
        String rawPassword = GlobalFunctions.PasswordGenerator(); // Create a method for this

        do {
            generatedUserId = GlobalFunctions.IdGenerator(GlobalConstants.InstitutionCode);
        } while (userServiceInterface.UserIdExists(generatedUserId));

        users.setUserId(generatedUserId);

        String encodedPassword = passwordEncoder.encode(rawPassword);
        users.setPassword(encodedPassword);

        userServiceInterface.registerUser(users);

        // Send welcome email
        try {
            emailService.sendWelcomeEmail(users.getEmail(), users.getFullName(), rawPassword); // Use the injected service here


        } catch (MessagingException e) {
            response.put("status", "error");
            response.put("message", "User Created but failed to send email");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("status", "success");
        response.put("message", "User Created Successfully");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }



}
