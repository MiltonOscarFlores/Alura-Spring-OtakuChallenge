package com.aluracursos.otakuchallenge.principal;
import com.aluracursos.otakuchallenge.model.AnimeImagenes;
import com.aluracursos.otakuchallenge.model.Jpg;
import com.aluracursos.otakuchallenge.model.Anime;
import com.aluracursos.otakuchallenge.model.AnimeData;
import com.aluracursos.otakuchallenge.services.JikanClientAPI;
import com.aluracursos.otakuchallenge.services.JikanDataParser;

import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static final String URL_BASE = "https://api.jikan.moe/v4/anime";
    private JikanClientAPI jikanClientAPI = new JikanClientAPI();
    private JikanDataParser jikanDataParser = new JikanDataParser();
private Scanner teclado = new Scanner(System.in);

    public void MostrarMenu(){
        var json = jikanClientAPI.obtenerDatos(URL_BASE);
//        System.out.println(json);
//        var datos = jikanDataParser.jikanJsonToObject(json, AnimeData.class);
//        System.out.println(datos);

        AnimeData animeData = jikanDataParser.jikanJsonToObject(json, AnimeData.class);

//        if (animeData != null && animeData.animeList() != null) {
//            animeData.animeList().stream().
//                    forEach(anime -> {
//                        System.out.println("Título en inglés: " + anime.TituloEnIngles());
//                        System.out.println("Título en japonés: " + anime.TituloEnJapones());
//                        System.out.println("Ranking: " + anime.Ranking());
//                        System.out.println("Estado: " + anime.Estado());
//                        System.out.println("Episodios: " + anime.CantidadDeEpisodios());
//                        String imageUrl = anime.images().map(AnimeImagenes::jpg).map(Jpg::imageUrl).orElse("Imagen no disponible");
//                        System.out.println("URL de la imagen: " + (imageUrl != null ? imageUrl : "Imagen no disponible"));
//                        System.out.println("--------------------");
//            });
//        }

//        // Top 10 mejores animes
//        System.out.println("Top 10 mejores animes según su Ranking");
//
//        animeData.animeList().stream()
//                .sorted(Comparator.comparingInt(Anime::Ranking).reversed())
//                .limit(10)
//                .forEach(anime -> {
//                    System.out.println("Título en inglés: " + anime.TituloEnIngles());
//                    System.out.println("Título en japonés: " + anime.TituloEnJapones());
//                    System.out.println("Ranking: " + anime.Ranking());
//                    System.out.println("--------------------");
//                });

        // Busqueda de Animes por nombre
        System.out.println("Ingrese el nombre del anime que desea buscar: ");
        var tituloAnime = teclado.nextLine();
        json = jikanClientAPI.obtenerDatos(URL_BASE + "?q=" + tituloAnime.replace(" ", "+"));
        AnimeData animeEncontrado = jikanDataParser.jikanJsonToObject(json, AnimeData.class);

        if (animeEncontrado != null && !animeEncontrado.animeList().isEmpty()) {
            Optional<Anime> animeBuscado = animeEncontrado.animeList().stream()
                    .filter(anime -> anime.TituloEnIngles().toUpperCase().contains(tituloAnime.toUpperCase()))
                    .findFirst();

            if (animeBuscado.isPresent()) {
                Anime anime = animeBuscado.get();
                System.out.println("Anime Encontrado:");
                System.out.println("Título en inglés: " + anime.TituloEnIngles());
                System.out.println("Título en japonés: " + anime.TituloEnJapones());
                System.out.println("Estado: " + anime.Estado());
                System.out.println("Cantidad de episodios: " + anime.CantidadDeEpisodios());
                System.out.println("Ranking: " + anime.Ranking());

                // Imprimir URL de la imagen si está disponible
                String imageUrl = anime.images().map(AnimeImagenes::jpg).map(Jpg::imageUrl).orElse("Imagen no disponible");
                System.out.println("URL de la imagen: " + (imageUrl != null ? imageUrl : "Imagen no disponible"));

                System.out.println("--------------------");
            } else {
                System.out.println("Anime NO encontrado");
            }

        } else {
            System.out.println("No se encontraron resultados.");
        }

    }
}
