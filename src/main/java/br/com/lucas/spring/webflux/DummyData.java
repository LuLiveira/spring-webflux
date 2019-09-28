package br.com.lucas.spring.webflux;

import br.com.lucas.spring.webflux.documents.PlayList;
import br.com.lucas.spring.webflux.repositories.PlayListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Component
public class DummyData implements CommandLineRunner {

    @Autowired
    private PlayListRepository playListRepository;

    @Override
    public void run(String... args) throws Exception {

        playListRepository.deleteAll().thenMany(Flux.just(
                "API Rest Spring boot",
                "Deploy de uma app",
                "Java 8",
                "Spring security"
        ).map(nome -> new PlayList(UUID.randomUUID().toString(), nome)) //Lambda.
                .flatMap(playListRepository::save)) //Reference methods.
                .subscribe(System.out::println); //Reference methods.
    }
}
