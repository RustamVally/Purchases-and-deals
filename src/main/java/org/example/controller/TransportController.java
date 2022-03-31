package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.manager.TransportManager;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TransportController {
    private TransportManager manager;

    // TODO: http://localhost:9999/add/type=
}
