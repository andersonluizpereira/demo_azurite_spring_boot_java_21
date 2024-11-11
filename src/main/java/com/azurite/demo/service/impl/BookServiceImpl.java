package com.azurite.demo.service.impl;

import com.azurite.demo.dto.BookDto;
import com.azurite.demo.entity.BookEntity;
import com.azurite.demo.repository.BookRepository;
import com.azurite.demo.service.BookService;
import com.azurite.demo.util.JsonConverter;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final JsonConverter jsonConverter;

    public BookServiceImpl(BookRepository bookRepository, JsonConverter jsonConverter) {
        this.bookRepository = bookRepository;
        this.jsonConverter = jsonConverter;
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        BookEntity bookEntity = toEntity(bookDto);
        bookRepository.save(bookEntity);
        return bookDto;
    }

    @Override
    public BookDto getBook(String isbn) {
        BookEntity bookEntity = bookRepository.findById("Book", isbn);
        return getBookDataConverter(bookEntity);
    }

    private BookDto getBookDataConverter(BookEntity bookEntity) {
        return JsonConverter.bookDtoConverter(String.valueOf(bookEntity.getProperty("BookData")));
    }

    @Override
    public BookDto updateBook(String isbn, BookDto bookDto) {
        BookEntity bookEntity = toEntity(bookDto);
        bookRepository.update(bookEntity);
        return bookDto;
    }

    @Override
    public void deleteBook(String isbn) {
        bookRepository.delete("Book", isbn);
    }

    @Override
    public List<BookDto> listBooks() {
        return bookRepository.findAll().stream().map(this::getBookDataConverter).collect(Collectors.toList());
    }

    private BookEntity toEntity(BookDto bookDto) {
        BookEntity bookEntity = new BookEntity("Book", bookDto.isbn());
        bookEntity.addProperty("BookData", new Gson().toJson(bookDto));

        return bookEntity;
    }

}
