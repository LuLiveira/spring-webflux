package br.com.lucas.spring.webflux.repositories;

import br.com.lucas.spring.webflux.documents.PlayList;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PlayListRepository extends ReactiveMongoRepository<PlayList, String> {

}
