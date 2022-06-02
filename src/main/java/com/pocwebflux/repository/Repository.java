package com.pocwebflux.repository;

import com.pocwebflux.entity.BasicEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface Repository extends ReactiveMongoRepository<BasicEntity, Long> {
    Mono<BasicEntity> findById(Long id);
}
