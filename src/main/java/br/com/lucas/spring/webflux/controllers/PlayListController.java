package br.com.lucas.spring.webflux.controllers;

import br.com.lucas.spring.webflux.documents.PlayList;
import br.com.lucas.spring.webflux.services.PlayListService;
import br.com.lucas.spring.webflux.services.PlayListServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

@RestController
public class PlayListController {

    @Autowired
    private PlayListService playListServiceImp;

    @GetMapping(value = "/playlist")
    public Flux<PlayList> getPlayList(){
        return playListServiceImp.findAll();
    }

    @GetMapping("/playlist/{id}")
    public Mono<PlayList> getPlayListById(@PathVariable String id){return playListServiceImp.findById(id);}

    @PostMapping(value = "/playlist")
    public Mono<PlayList> postPlayList(@RequestBody PlayList playList){ return playListServiceImp.save(playList);}

    //Stream de eventos.
    //Não espera 1 requisição terminar para iniciar as próximas.
    @GetMapping(value = "/playlist/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, PlayList>> getPlayListEvents(){
        Flux<Long> interval = Flux.interval(Duration.ofMinutes(1));
        Flux<PlayList> events = playListServiceImp.findAll();
        return Flux.zip(interval, events);
    }
}
