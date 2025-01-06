package com.aluracursos.otakuchallenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AnimeImagenes(
        @JsonAlias("jpg") Jpg jpg
) {}

