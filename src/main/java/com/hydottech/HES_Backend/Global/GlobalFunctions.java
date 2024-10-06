package com.hydottech.HES_Backend.Global;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class GlobalFunctions {

    public static String saveFile(MultipartFile file) {
        String uploadDirectory = "/Users/glydetek/Desktop/HydotTech/Products/HES/HES_Backend/Uploads/"; // Ensure there's a trailing slash
        String originalFilename = file.getOriginalFilename();

        if (originalFilename == null) {
            throw new IllegalArgumentException("File name cannot be null");
        }

        // Extract the file extension from the original file name
        String fileExtension = "";
        int dotIndex = originalFilename.lastIndexOf('.');
        if (dotIndex >= 0) {
            fileExtension = originalFilename.substring(dotIndex);
        }

        // Add a UUID to the file name to avoid collisions, and append the file extension
        String uniqueFileName = UUID.randomUUID().toString() + fileExtension;

        File uploadDir = new File(uploadDirectory);

        // Ensure the upload directory exists
        if (!uploadDir.exists()) {
            boolean created = uploadDir.mkdirs(); // Creates the directory and any necessary parent directories
            if (!created) {
                throw new RuntimeException("Failed to create upload directory: " + uploadDirectory);
            }
        }

        File destinationFile = new File(uploadDir, uniqueFileName); // Create the destination file in the upload directory

        try {
            file.transferTo(destinationFile); // Save the file
        } catch (IOException e) {
            e.printStackTrace(); // Consider using a logging framework
            throw new RuntimeException("Failed to save file: " + e.getMessage(), e);
        }

        // Return the unique file name
        return uniqueFileName;
    }



}
