package com.example.sonarcloud_reto.service;

import com.example.sonarcloud_reto.model.History;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HistoryService {
    Flux<History> listSpeech();

    Mono<String> generateSpeech(String text);
}