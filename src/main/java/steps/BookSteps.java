package steps;

import config.configuration.BooksConfig;
import dto.response.books.BookResponseDTO;
import dto.response.books.BooksResponseDTO;
import dto.response.books.IsbnResponseDTO;

import static config.base.Requests.post;
import static config.builders.BookBuilders.book;
import static config.specification.ResponseSpec.created;
import static config.specification.ResponseSpec.ok;
import static org.aeonbits.owner.ConfigFactory.create;
import static org.aeonbits.owner.ConfigFactory.getProperties;
import static config.base.Requests.get;

public class BookSteps {

    private final BooksConfig config = create(BooksConfig.class, getProperties());

    public BooksResponseDTO getAllBooks() {
        return get(config.getAllBooks()).spec(ok()).extract().as(BooksResponseDTO.class);
    }

    public BookResponseDTO getBook(String isbn) {
        return get(config.getBook(), isbn).spec(ok()).extract().as(BookResponseDTO.class);
    }

    public IsbnResponseDTO addBookIntoUser(String isbn) {
        return post(book(config.userId(), isbn), config.addBook()).spec(created()).extract().as(IsbnResponseDTO.class);
    }
}
