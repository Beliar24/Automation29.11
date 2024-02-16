import org.testng.annotations.Test;
import steps.BookSteps;
import steps.UserSteps;

import static org.assertj.core.api.Assertions.assertThat;


public class BasicTest {

    @Test
    void start() {
        var tokenDto = new UserSteps().generateToken();

        assertThat(tokenDto.getResult()).isEqualTo("User authorized successfully.");
    }

    @Test
    void getAllBooks() {
        var books = new BookSteps().getAllBooks().getBooks();

        System.out.println(books);
    }
}
