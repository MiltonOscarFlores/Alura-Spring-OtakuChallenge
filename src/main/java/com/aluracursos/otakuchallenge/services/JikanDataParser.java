package com.aluracursos.otakuchallenge.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

public class JikanDataParser implements IJikanDataParser{
    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new Jdk8Module());

    @Override
    public <T> T jikanJsonToObject(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
