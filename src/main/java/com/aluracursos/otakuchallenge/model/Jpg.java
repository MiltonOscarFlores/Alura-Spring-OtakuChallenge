package com.aluracursos.otakuchallenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Jpg(
        @JsonAlias("image_url") String imageUrl,
        @JsonAlias("small_image_url") String smallImageUrl,
        @JsonAlias("large_image_url") String largeImageUrl
) {}
