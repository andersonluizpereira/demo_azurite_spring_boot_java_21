package com.azurite.demo.service.impl;

import com.azurite.demo.dto.BookDto;
import com.azurite.demo.entity.BookEntity;
import com.azurite.demo.repository.BookRepository;
import com.azurite.demo.util.JsonConverter;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private JsonConverter jsonConverter;

    @InjectMocks
    private BookServiceImpl bookService;

    private BookDto sampleBookDto;
    private BookEntity sampleBookEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Criação de um BookDto de exemplo
        sampleBookDto = new BookDto(
                "978-3-16-148410-1",
                "Usado",
                "Ficção",
                "Português",
                "Aventuras no Mundo da Programação - Edição Atualizada",
                "João da Silva",
                "Programadores Editora",
                2023,
                2,
                new BigDecimal(45.0),
                320,
                "Edição atualizada com novas aventuras no mundo da programação.",
                "link_da_imagem_atualizada.jpg"
        );

        // Criação de um BookEntity de exemplo
        sampleBookEntity = new BookEntity("Book", sampleBookDto.isbn());
        sampleBookEntity.addProperty("BookData", new Gson().toJson(sampleBookDto));
    }

    @Test
    void testCreateBook() {
        // Simula o comportamento do método void save
        doNothing().when(bookRepository).save(any(BookEntity.class));

        // Executa o método que queremos testar
        BookDto result = bookService.createBook(sampleBookDto);

        // Verificações
        assertNotNull(result);
        assertEquals(sampleBookDto.isbn(), result.isbn());

        // Verifica se o método save foi chamado uma vez
        verify(bookRepository, times(1)).save(any(BookEntity.class));
    }

    @Test
    void testGetBook() {
        // Configura o JSON para BookData
        String bookDataJson = new Gson().toJson(sampleBookDto);
        sampleBookEntity.addProperty("BookData", bookDataJson);

        when(bookRepository.findById("Book", sampleBookDto.isbn())).thenReturn(sampleBookEntity);

        BookDto result = bookService.getBook(sampleBookDto.isbn());

        assertNotNull(result);
        assertEquals(sampleBookDto.isbn(), result.isbn());
        verify(bookRepository, times(1)).findById("Book", sampleBookDto.isbn());
    }

    @Test
    void testUpdateBook() {
        // Simula o comportamento do método void
        doNothing().when(bookRepository).update(any(BookEntity.class));

        // Executa o método que queremos testar
        BookDto result = bookService.updateBook(sampleBookDto.isbn(), sampleBookDto);

        // Verificações
        assertNotNull(result);
        assertEquals(sampleBookDto.isbn(), result.isbn());

        // Verifica se o método update foi chamado uma vez
        verify(bookRepository, times(1)).update(any(BookEntity.class));
    }

    @Test
    void testDeleteBook() {
        doNothing().when(bookRepository).delete("Book", sampleBookDto.isbn());

        bookService.deleteBook(sampleBookDto.isbn());

        verify(bookRepository, times(1)).delete("Book", sampleBookDto.isbn());
    }

    @Test
    void testListBooks() {
        when(bookRepository.findAll()).thenReturn(List.of(sampleBookEntity));

        List<BookDto> result = bookService.listBooks();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(sampleBookDto.isbn(), result.get(0).isbn());
        verify(bookRepository, times(1)).findAll();
    }
}
