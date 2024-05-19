package com.example.sonarcloud_reto.repository;

import com.example.sonarcloud_reto.model.History;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
public interface HistoryRepository extends R2dbcRepository<History, Long> {
    Flux<History> findAll();
}
