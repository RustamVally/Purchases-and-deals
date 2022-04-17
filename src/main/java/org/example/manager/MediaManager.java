package org.example.manager;

import org.springframework.stereotype.Component;

import java.nio.file.Path;

@Component
public class MediaManager {
    private final Path path = Path.of("media");

}
