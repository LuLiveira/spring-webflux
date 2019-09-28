package br.com.lucas.spring.webflux.services;

import br.com.lucas.spring.webflux.documents.PlayList;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlayListService {

    Flux<PlayList> findAll();
    Mono<PlayList> findById(String id);
    Mono<PlayList> save(PlayList playList);

}
