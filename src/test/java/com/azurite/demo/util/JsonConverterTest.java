package com.azurite.demo.util;

import com.azurite.demo.dto.BookDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class JsonConverterTest {

    @Test
    void testBookDtoConverter() {
        // JSON de teste
        String json = "{\"isbn\":\"978-3-16-148410-1\",\"tipoLivro\":\"Novo\",\"estante\":\"Ficção\",\"idioma\":\"Português\",\"titulo\":\"Aventuras no Mundo da Programação\",\"autor\":\"João da Silva\",\"editora\":\"Programadores Editora\",\"ano\":2023,\"edicao\":1,\"preco\":49.9,\"peso\":300,\"descricao\":\"Um livro sobre aventuras no mundo da programação.\",\"capa\":\"link_da_imagem.jpg\"}";

        // Executa o método de conversão
        BookDto bookDto = JsonConverter.bookDtoConverter(json);

        // Verificações
        Assertions.assertNotNull(bookDto, "O objeto BookDto não deve ser nulo");
        Assertions.assertEquals("978-3-16-148410-1", bookDto.isbn());
        Assertions.assertEquals("Novo", bookDto.tipo_livro());
        Assertions.assertEquals("Ficção", bookDto.estante());
        Assertions.assertEquals("Português", bookDto.idioma());
        Assertions.assertEquals("Aventuras no Mundo da Programação", bookDto.titulo());
        Assertions.assertEquals("João da Silva", bookDto.autor());
        Assertions.assertEquals("Programadores Editora", bookDto.editora());
        Assertions.assertEquals(2023, bookDto.ano());
        Assertions.assertEquals(1, bookDto.edicao());
        Assertions.assertEquals(new BigDecimal("49.9"), bookDto.preco());
        Assertions.assertEquals(300, bookDto.peso());
        Assertions.assertEquals("Um livro sobre aventuras no mundo da programação.", bookDto.descricao());
        Assertions.assertEquals("link_da_imagem.jpg", bookDto.capa());
    }
}