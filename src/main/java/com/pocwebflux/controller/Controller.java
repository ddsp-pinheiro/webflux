package com.pocwebflux.controller;

import com.pocwebflux.entity.BasicEntity;
import com.pocwebflux.repository.Repository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("/webflux")
public class Controller {
    private final Repository repository;

    @PostMapping
    public ResponseEntity<Mono<BasicEntity>> post(@RequestBody BasicEntity basicEntity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(basicEntity));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<BasicEntity>> getById(@PathVariable long id) {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp));
    }

    @GetMapping
    private Flux<BasicEntity> getAll() {
        return repository.findAll();
    }
}
