package com.pocwebflux.service;

import com.pocwebflux.entity.BasicEntity;
import com.pocwebflux.repository.Repository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class Service {

    private static final String ID_NOT_FOUND = "Id not found";
    private final Repository repository;

    public Mono<BasicEntity> save(BasicEntity basicEntity){
        return repository.save(basicEntity);
    }

    public Mono<BasicEntity> getById(final Long id){
        return repository.findById(id);
    }
}
