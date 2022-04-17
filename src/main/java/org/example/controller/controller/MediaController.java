package org.example.controller.controller;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.UploadSingleMediaResponseDTO;
import org.example.manager.MediaManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/media")
public class MediaController {
    private final MediaManager manager;

    @PostMapping("/bytes")
    public UploadSingleMediaResponseDTO upload(@RequestBody byte[] bytes, @RequestHeader("Content-Type") String contentType) {
        return manager.save(bytes, contentType);
    }
}
