package com.azurite.demo.dto;

public class BookData {
    private BookDto bookDto;

    public BookData(BookDto bookDto) {
        this.bookDto = bookDto;
    }

    public BookDto getBookDto() {
        return bookDto;
    }

    public void setBookDto(BookDto bookDto) {
        this.bookDto = bookDto;
    }
}
