package com.azurite.demo.util;

import com.azurite.demo.dto.BookDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

@Component
public class JsonConverter {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static BookDto bookDtoConverter(String json) {
        BookDto bookDto = null;
        try {
            // Converte o JSON para o objeto BookDto usando Jackson
            bookDto = objectMapper.readValue(json, BookDto.class);
            System.out.println(bookDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookDto;
    }

    public String toJson(BookDto bookDto) {
        return new Gson().toJson(bookDto.toString());
    }
}