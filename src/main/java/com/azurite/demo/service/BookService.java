package com.azurite.demo.service;

import com.azurite.demo.dto.BookDto;

import java.util.List;

public interface BookService {

    BookDto createBook(BookDto bookDto);

    BookDto getBook(String isbn);

    BookDto updateBook(String isbn, BookDto bookDto);

    void deleteBook(String isbn);

    List<BookDto> listBooks();
}
