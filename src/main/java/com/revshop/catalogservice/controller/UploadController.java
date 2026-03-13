package com.revshop.catalogservice.controller;

import com.revshop.catalogservice.dto.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

    private static final Logger log = LoggerFactory.getLogger(UploadController.class);

    @Value("${upload.dir:uploads}")
    private String uploadDir;

    @Value("${upload.serve-path:/api/images}")
    private String servePath;

    @PostMapping
    public ResponseEntity<ApiResponse<Map<String, String>>> upload(@RequestParam("file") MultipartFile file) throws IOException {
        log.info("POST /api/upload - filename={} size={}", file.getOriginalFilename(), file.getSize());

        // Create uploads directory if it doesn't exist
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Generate unique filename
        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename != null && originalFilename.contains(".")
                ? originalFilename.substring(originalFilename.lastIndexOf("."))
                : ".jpg";
        String newFilename = UUID.randomUUID().toString() + extension;

        // Save file
        Path filePath = uploadPath.resolve(newFilename);
        Files.write(filePath, file.getBytes());

        // Return accessible URL (served via static resources)
        String url = servePath + "/" + newFilename;
        log.info("File uploaded successfully: {}", url);

        return ResponseEntity.ok(new ApiResponse<>("File uploaded successfully", Map.of("url", url)));
    }
}
