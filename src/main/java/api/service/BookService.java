package api.service;

import api.dto.response.books.BookResponseDTO;
import api.steps.BookSteps;
import api.exceptions.BookNotFoundException;
import io.qameta.allure.Step;

import static java.lang.String.format;

public class BookService {

    BookSteps book = new BookSteps();

    @Step("Get isbn book from title -> {title}")
    public String getIsbnOfBook(String title) {
        var books = book.getAllBooks().getBooks();
        return books.stream()
                .filter(bookTitle -> bookTitle.getTitle().equals(title))
                .map(BookResponseDTO::getIsbn)
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException(format("Book - %s is not found", title)));
    }

    public Boolean checkIsbnBook(String title) {
        var books = book.getAllBooks().getBooks();
        return books.stream()
                .filter(bookTitle -> bookTitle.getTitle().equals(title))
                .map(BookResponseDTO::getIsbn)
                .findFirst()
                .isEmpty();
    }
}
