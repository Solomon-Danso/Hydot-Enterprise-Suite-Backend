package com.hydottech.HES_Backend.Controller;

import com.hydottech.HES_Backend.Entity.Users;
import com.hydottech.HES_Backend.Global.GlobalFunctions;
import com.hydottech.HES_Backend.Service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UsersController {
    @Autowired
    private UserServiceInterface userServiceInterface;

@GetMapping("/")
    public String Test(){
    return "Let Start The Hydot Commerce System";
}


    @PostMapping("/Register")
    public ResponseEntity<Map<String, Object>> registerUser(@ModelAttribute Users users,
                                                            @RequestParam("pic") MultipartFile pic,
                                                            @RequestParam("vid") MultipartFile vid) {
        Map<String, Object> response = new HashMap<>();

        // Check if the file is not empty
        if (!pic.isEmpty()) {
            String fileName = GlobalFunctions.saveFile(pic);
            users.setPicture(fileName); // Save the file path in the Picture column
        }

//        if (!vid.isEmpty()) {
//            String fileName = GlobalFunctions.saveFile(vid);
//            users.setFullName(fileName); // Save the file path in the Picture column
//        }

        userServiceInterface.registerUser(users);

        // Prepare response
        response.put("status", "success");
        response.put("message", "User Created Successfully");

        return new ResponseEntity<>(response, HttpStatus.CREATED); // Return 201 Created status
    }






}
