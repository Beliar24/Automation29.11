package api.steps;

import api.config.base.requestImpl.CommonRequestHandler;
import api.config.configuration.BooksConfig;
import api.dto.response.books.BookResponseDTO;
import api.dto.response.books.BooksResponseDTO;
import api.dto.response.books.IsbnResponseDTO;
import io.qameta.allure.Step;

import static api.config.builders.BookBuilders.book;
import static api.config.specification.ResponseSpec.created;
import static api.config.specification.ResponseSpec.noContent;
import static api.config.specification.ResponseSpec.ok;
import static org.aeonbits.owner.ConfigFactory.create;
import static org.aeonbits.owner.ConfigFactory.getProperties;

public class BookSteps {

    private final BooksConfig config = create(BooksConfig.class, getProperties());
    private final CommonRequestHandler request = new CommonRequestHandler();

    public BooksResponseDTO getAllBooks() {
        return request.get(config.getAllBooks()).spec(ok()).extract().as(BooksResponseDTO.class);
    }

    public BookResponseDTO getBook(String isbn) {
        return request.get(config.getBook(), isbn).spec(ok()).extract().as(BookResponseDTO.class);
    }

    @Step("Add book into user using isbn -> {isbn}")
    public IsbnResponseDTO addBookIntoUser(String isbn) {
        return request.post(book(config.userId(), isbn), config.addBook()).spec(created()).extract().as(IsbnResponseDTO.class);
    }

    @Step("Delete all book from user")
    public void deleteBook() {
        request.delete(config.deleteBook(), config.userId()).spec(noContent());
    }
}
