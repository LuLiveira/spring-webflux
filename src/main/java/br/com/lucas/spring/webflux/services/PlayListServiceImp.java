package br.com.lucas.spring.webflux.services;

import br.com.lucas.spring.webflux.documents.PlayList;
import br.com.lucas.spring.webflux.repositories.PlayListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlayListServiceImp implements PlayListService {

    @Autowired
    private PlayListRepository playListRepository;

    @Override
    public Flux<PlayList> findAll() {
        return playListRepository.findAll();
    }

    @Override
    public Mono<PlayList> findById(String id) {
        return playListRepository.findById(id);
    }

    @Override
    public Mono<PlayList> save(PlayList playList) {
        return playListRepository.save(playList);
    }
}
