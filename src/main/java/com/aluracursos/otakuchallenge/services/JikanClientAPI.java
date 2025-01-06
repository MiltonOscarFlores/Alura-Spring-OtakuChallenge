package com.aluracursos.otakuchallenge.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JikanClientAPI {

    /**
     * Obtiene datos de la API de Jikan.
     *
     * @param url La URL de la API de Jikan.
     * @return Una cadena JSON con los datos obtenidos de la API.
     * @throws JikanApiException Si ocurre un error al realizar la solicitud o si la API devuelve un código de estado de error.
     */
    public String obtenerDatos(String url) throws JikanApiException {
        // Crea un cliente HTTP.
        HttpClient client = HttpClient.newHttpClient();

        // Crea una solicitud HTTP.
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url)) // Establece la URI de la solicitud.
                .build();

        HttpResponse<String> response; // Variable para almacenar la respuesta.

        try {
            // Envía la solicitud y obtiene la respuesta.
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            // Si ocurre un error de IO o interrupción, lanza una excepción personalizada.
            throw new JikanApiException("Error de conexión a la API de Jikan: " + e.getMessage(), 0);
        }

        // Verifica si el código de estado indica un error (códigos 4xx o 5xx).
        if (response.statusCode() < 200 || response.statusCode() >= 300) {
            // Si hay un error, lanza una excepción personalizada con el código de estado y el cuerpo de la respuesta.
            throw new JikanApiException("Error en la API de Jikan (" + response.statusCode() + "): " + response.body(), response.statusCode());
        }

        // Si la solicitud fue exitosa, retorna el cuerpo de la respuesta (JSON).
        return response.body();
    }
}