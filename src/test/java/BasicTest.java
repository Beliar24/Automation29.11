import dto.response.books.BookResponseDTO;
import exceptions.BookNotFoundException;
import org.testng.annotations.Test;
import service.BookService;
import steps.BookSteps;
import steps.UserSteps;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;


public class BasicTest {

    private final String BOOK_TITLE = "Programming JavaScript Applications";

    @Test
    void shouldBeUserReturned() {
        var user = new UserSteps().getUser();
        assertThat(user.getUsername()).as("Username is not correct").isEqualTo("user15");
    }

//    @Test
//    void getAllBooks() {
//        var books = new BookSteps().getAllBooks().getBooks();
//
//        var book = new BookSteps().getBook();
//
//        System.out.println(book);
//    }

    @Test
    void shouldBeAddedOneBookIntoUser() {
        var isbn = new BookService().getIsbnOfBook(BOOK_TITLE);

        new BookSteps().addBookIntoUser(isbn);

        var user = new UserSteps().getUser();

        var bookTitle = user.getBooks().stream().map(BookResponseDTO::getTitle).filter(title -> title.equals(BOOK_TITLE))
                        .findFirst().orElseThrow(() -> new BookNotFoundException(format("Book - %s is not found", BOOK_TITLE)));

        assertThat(bookTitle).as("Title is not correct").isEqualTo(BOOK_TITLE);

    }
}
