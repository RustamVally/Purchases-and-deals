package org.example.manager;

import org.example.controller.dto.UploadSingleMediaResponseDTO;
import org.example.exception.UnsupportedContentTypeException;
import org.example.exception.UploadException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.UUID;

@Component
public class MediaManager {
    private final Path path = Path.of("media");
    // расширение
    private final Map<String, String> types = Map.of(
            "image/jpeg", ".jpg"
    );

    public MediaManager() throws IOException {
        Files.createDirectories(path);
    }

    // TODO:
    //  1. Сгенерировать имя и определить расширение
    //  2. Сохранить
    public UploadSingleMediaResponseDTO save(byte[] bytes, String contentType) {
        try {
            final String name = UUID.randomUUID() + getExtension(contentType); // имя файла
            Files.write(path.resolve(name), bytes);
            return new UploadSingleMediaResponseDTO(name);
        } catch (IOException e) {
            e.printStackTrace();
         throw new UploadException(e);
        }
    }

    private String getExtension(String contentType) {
        final String extension = types.get(contentType);
        if (extension == null) {
            throw new UnsupportedContentTypeException(contentType + " not allowed for upload");
        }
        return extension;

    }
}
