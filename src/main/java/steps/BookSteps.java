package steps;

import config.configuration.BooksConfig;
import dto.response.books.BooksResponseDTO;

import static config.specification.ResponseSpec.ok;
import static org.aeonbits.owner.ConfigFactory.create;
import static org.aeonbits.owner.ConfigFactory.getProperties;
import static config.base.Requests.get;

public class BookSteps {

    private final BooksConfig config = create(BooksConfig.class, getProperties());

    public BooksResponseDTO getAllBooks() {
        return get(config.getAllBooks()).spec(ok()).extract().as(BooksResponseDTO.class);
    }
}
