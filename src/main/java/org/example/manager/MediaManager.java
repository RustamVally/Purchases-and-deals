package org.example.manager;

import org.example.dto.UploadMultipleMediaResponseDTO;
import org.example.dto.UploadSingleMediaResponseDTO;
import org.example.exception.UnsupportedContentTypeException;
import org.example.exception.UploadException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

// TODO:
//  1. Сгенерировать имя и определить расширение
//  2. Сохранить
@Component
public class MediaManager {
    private final Path path = Path.of("media");
    private final Map<String, String> types = Map.of(
            "image/jpeg", ".jpg"
    );
    // по желанию можно добавить .png формат в мапу (или mp3, video)
    public MediaManager() throws IOException {
        Files.createDirectories(path);
    }

    public UploadSingleMediaResponseDTO save(byte[] bytes, String contentType) {
        try {
            final String name = generateName(contentType);
            Files.write(path.resolve(name), bytes);
            return new UploadSingleMediaResponseDTO(name);
        } catch (IOException e) {
            e.printStackTrace();
            throw new UploadException(e);
        }
    }

    public UploadSingleMediaResponseDTO save(MultipartFile file) {
        try {
            final String name = generateName(file.getContentType());
            file.transferTo(path.resolve(name));
            return new UploadSingleMediaResponseDTO(name);
        } catch (IOException e) {
            throw new UploadException(e);
        }
    }

    public UploadMultipleMediaResponseDTO save(List<MultipartFile> files) {
        final UploadMultipleMediaResponseDTO responseDTO = new UploadMultipleMediaResponseDTO(new ArrayList<>(files.size()));
        for (MultipartFile file : files) {
            final UploadSingleMediaResponseDTO saved = save(file);
            responseDTO.getNames().add(saved.getName());
        }
        return responseDTO;
    }

    private String generateName(String contentType) {
        return UUID.randomUUID() + getExtension(contentType);
    }

    private String getExtension(String contentType) {
        final String extension = types.get(contentType);
        if (extension == null) {
            throw new UnsupportedContentTypeException(contentType + " not allowed for upload");
        }
        return extension;

    }
}
