package steps;

import config.base.requestImpl.CommonRequestHandler;
import config.configuration.BooksConfig;
import dto.response.books.BookResponseDTO;
import dto.response.books.BooksResponseDTO;
import dto.response.books.IsbnResponseDTO;

import static config.builders.BookBuilders.book;
import static config.specification.ResponseSpec.created;
import static config.specification.ResponseSpec.ok;
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

    public IsbnResponseDTO addBookIntoUser(String isbn) {
        return request.post(book(config.userId(), isbn), config.addBook()).spec(created()).extract().as(IsbnResponseDTO.class);
    }
}
