package br.com.lucas.spring.webflux.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document //A anotação @Document vai mapear o nosso Objeto (Playlist) com o Document (Entidade em NoSQL) no MongoDB.
public class PlayList {

    @Id
    private String id;
    private String nome;

    public PlayList() {
    }

    public PlayList(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
