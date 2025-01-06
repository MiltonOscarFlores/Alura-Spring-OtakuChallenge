package com.aluracursos.otakuchallenge.services;

/**
 * Excepción personalizada para manejar errores de la API de Jikan.
 * Extiende de RuntimeException para indicar que es una excepción no controlada.
 */
public class JikanApiException extends RuntimeException {

    /**
     * Código de estado HTTP de la respuesta de la API.
     */
    private final int statusCode;

    /**
     * Constructor de la excepción.
     *
     * @param message   Mensaje de error descriptivo.
     * @param statusCode Código de estado HTTP.
     */
    public JikanApiException(String message, int statusCode) {
        super(message); // Llama al constructor de la clase padre (RuntimeException) para inicializar el mensaje de error.
        this.statusCode = statusCode; // Guarda el código de estado HTTP.
    }

    /**
     * Obtiene el código de estado HTTP.
     *
     * @return El código de estado HTTP.
     */
    public int getStatusCode() {
        return statusCode;
    }
}