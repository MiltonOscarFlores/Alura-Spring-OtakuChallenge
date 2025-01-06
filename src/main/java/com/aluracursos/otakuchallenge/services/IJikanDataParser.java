package com.aluracursos.otakuchallenge.services;

public interface IJikanDataParser {
    <T> T jikanJsonToObject(String json, Class<T> clase);
}
