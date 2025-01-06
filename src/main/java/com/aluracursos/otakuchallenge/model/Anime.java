package com.aluracursos.otakuchallenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Optional;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Anime(
        @JsonAlias("title_english") String TituloEnIngles,
        @JsonAlias("title_japanese") String TituloEnJapones,
        @JsonAlias("status") String Estado,
        @JsonAlias("episodes") Integer CantidadDeEpisodios,
        @JsonAlias("mal_id") Integer ID,
        @JsonAlias("images") Optional<AnimeImagenes> images,
        @JsonAlias("rank") Integer Ranking

) {
}
