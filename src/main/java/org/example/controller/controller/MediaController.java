package org.example.controller.controller;

import lombok.RequiredArgsConstructor;
import org.example.manager.MediaManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/media")
public class MediaController {
    private final MediaManager manager;

    @RequestMapping
}
