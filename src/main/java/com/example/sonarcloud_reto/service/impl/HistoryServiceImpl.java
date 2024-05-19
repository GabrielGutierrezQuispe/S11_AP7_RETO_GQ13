package com.example.sonarcloud_reto.service.impl;

import com.example.sonarcloud_reto.model.History;
import com.example.sonarcloud_reto.repository.HistoryRepository;
import com.example.sonarcloud_reto.service.HistoryService;
import com.microsoft.cognitiveservices.speech.SpeechSynthesizer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository historyRepository;
    private final SpeechSynthesizer speechSynthesizer;
    private static final Logger LOGGER = LogManager.getLogger(HistoryServiceImpl.class);
    @Override
    public Flux<History> listSpeech() {
        return historyRepository.findAll();
    }

    @Override
    public Mono<String> generateSpeech(String text) {
        return Mono.just(text)
                .filter(t -> !t.isEmpty())
                .flatMap(t -> {
                    try {
                        speechSynthesizer.SpeakTextAsync(t).get();
                        History newText = new History(null, t);
                        return historyRepository.save(newText)
                                .thenReturn("Texto: [" + t + "] sintetizado correctamente.");
                    } catch (InterruptedException e) {
                        LOGGER.log(Level.WARN, "Interrupted!", e);
                        Thread.currentThread().interrupt();
                        return Mono.error(new RuntimeException("Error al sintetizar el texto a voz: " + e.getMessage()));
                    } catch (ExecutionException e) {
                        return Mono.error(new RuntimeException("Error al sintetizar el texto a voz: " + e.getMessage()));
                    }
                });
    }
}