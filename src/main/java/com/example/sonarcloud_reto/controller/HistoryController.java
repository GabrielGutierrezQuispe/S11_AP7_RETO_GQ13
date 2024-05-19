package com.example.sonarcloud_reto.controller;

import com.example.sonarcloud_reto.model.History;
import com.example.sonarcloud_reto.service.impl.HistoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/speech")
public class HistoryController {

    private final HistoryServiceImpl historyServiceImpl;

    @GetMapping("/list")
    public Flux<History> listSpeech() {
        return historyServiceImpl.listSpeech();
    }

    @PostMapping("/save")
    public Mono<String> generateSpeech(@RequestBody String text) {
        return historyServiceImpl.generateSpeech(text);
    }
}
